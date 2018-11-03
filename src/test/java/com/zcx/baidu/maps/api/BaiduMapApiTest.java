package com.zcx.baidu.maps.api;

import com.google.gson.Gson;
import com.zcx.baidu.maps.model.PlacesSearchResponse;
import com.zcx.baidu.maps.model.PlacesSearchResult;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Test;

/**
 * @description: ${description}
 * @author: zhangchunxing
 * @create: 2018-11-03
 **/
public class BaiduMapApiTest {
    private final String hostName = "http://api.map.baidu.com";
    private final String placeSearchUrl = "/place/v2/search";
    private final String SK = "4EOhUAvNHmEcAj15xBEFY08BLzPNOnIV";
    private final String whiteSK = "rmynlXFYNXdT9WusBmRcziCZYGLMufOY";

    public final OkHttpClient client = new OkHttpClient();

    private Gson gs = new Gson();


    /**
     * 行政区域检索
     * http://api.map.baidu.com/place/v2/search?
     * query=ATM机&tag=银行&region=北京&output=json&ak=您的ak //GET请求
     * @throws Exception
     */
    @Test
    public void AdministrativeRegionsSearchTest () throws Exception {

        HttpUrl httpUrl = HttpUrl.parse(hostName+placeSearchUrl).newBuilder()
                .addQueryParameter("query", "ATM机")
                .addQueryParameter("tag", "银行")
                .addQueryParameter("region", "北京")
                .addQueryParameter("output", "json")
                .addQueryParameter("ak", whiteSK).build();

        System.out.println(httpUrl.toString());

        Request request = new Request.Builder()
                .url(httpUrl)
                .build();

        Response response = client.newCall(request).execute();

        if (response.isSuccessful()) {
            //如果请求成功，通知Handler更新数据
            String res = response.body().string();
            PlacesSearchResponse ps = gs.fromJson(res, PlacesSearchResponse.class);

            PlacesSearchResult[] placesSearchResults = ps.results;
            for (PlacesSearchResult result : placesSearchResults) {
                System.out.println(result.address);
            }
        }
    }
}
