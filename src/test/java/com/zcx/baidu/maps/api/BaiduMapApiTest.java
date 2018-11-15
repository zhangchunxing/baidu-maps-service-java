package com.zcx.baidu.maps.api;

import com.google.gson.Gson;
import com.zcx.baidu.maps.common.GeoApiContext;
import com.zcx.baidu.maps.model.DistrictRegionSearchRequest;
import com.zcx.baidu.maps.model.PlacesSearchResponse;
import com.zcx.baidu.maps.model.PlacesSearchResult;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Before;
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

    private GeoApiContext geoApiContext;

    @Before
    public void setup() {
        geoApiContext = new GeoApiContext(whiteSK);
    }

    // 计算sn跟参数对出现顺序有关，
    // get请求请使用LinkedHashMap保存<key,value>，
    // 该方法根据key的插入顺序排序；post请使用TreeMap保存<key,value>，
    // 该方法会自动将key按照字母a-z顺序排序。
    // 所以get请求可自定义参数顺序（sn参数必须在最后）发送请求，
    // 但是post请求必须按照字母a-z顺序填充body（sn参数必须在最后）。
    // 以get请求为例：http://api.map.baidu.com/geocoder/v2/?address=百度大厦&output=json&ak=yourak，
    // paramsMap中先放入address，再放output，然后放ak，放入顺序必须跟get请求中对应参数的出现顺序保持一致。

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

    @Test
    public void AdministrativeRegionsSearchTest2 () throws Exception {
        new DistrictRegionSearchRequest(geoApiContext).query("ATM机").tag("银行").region("北京").makeRequest();

    }

    @Test
    public void AdministrativeRegionsSearchTest3 () throws Exception {
        PlaceApi.districtRegionSearchQuery(geoApiContext, "ATM机", "北京").tag("银行").cityLimit(true).makeRequest();

    }

    @Test
    public void  CircularRegionSearchTest () throws Exception {

    }
}
