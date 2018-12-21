package com.zcx.baidu.maps.common;

import com.google.gson.Gson;
import com.zcx.baidu.maps.model.BaseApiResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * @description:  这个类应该设计成单例！
 * @author: zhangchunxing
 * @create: 2018-11-05
 */
public class GeoApiContext {
	private final String AK;

	private final OkHttpClient client = new OkHttpClient();

	private final Gson gs = new Gson();

	public GeoApiContext(String AK) {
		this.AK = AK;
	}

	public <R extends BaseApiResponse> R get(ApiConfig apiConfig, Map<String, String> params,
	                                                            Class<R> clazz) throws IOException {
		StringBuilder url = new StringBuilder(apiConfig.hostName + apiConfig.path);

		params.put("ak", AK);
		// 拼接请求参数，并做UTF-8的编码
		params.forEach((key, value) -> {
			url.append('&').append(key).append("=");
			try {
				url.append(URLEncoder.encode(value, "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				// This should never happen. UTF-8 support is required for every Java implementation.
				throw new IllegalStateException(e);
			}
		});

		Request request = new Request.Builder()
				.url(url.toString())
				.build();

		System.err.println(request);

		Response response = client.newCall(request).execute();

		R ps = null;
		if (response.isSuccessful()) {
			//如果请求成功，通知Handler更新数据
			String res = response.body().string();
			ps = gs.fromJson(res, clazz);

			// if (ps.status == 0) {
			// 	PlacesSearchResult[] placesSearchResults = ps.results;
			// 	for (PlacesSearchResult result : placesSearchResults) {
			// 		System.out.println(result.uid);
			// 	}
			// }
		}

		return ps;

	}


}
