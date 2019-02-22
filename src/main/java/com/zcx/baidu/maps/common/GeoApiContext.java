package com.zcx.baidu.maps.common;

import com.google.gson.Gson;
import com.zcx.baidu.maps.model.ApiResponse;
import com.zcx.baidu.maps.util.SnCalHelper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.Instant;
import java.util.Map;

/**
 * 请求百度API的入口
 *
 * @author: zhangchunxing
 * @create: 2018-11-05
 */
public class GeoApiContext {

	private String AK;
	private String SK;

	private final OkHttpClient client = new OkHttpClient();
	private final Gson gs = new Gson();

	public GeoApiContext(String AK) {
		this.AK = AK;
	}

	public <R extends ApiResponse> R get(ApiConfig apiConfig, Map<String, String> params,
	                                     Class<R> clazz) throws IOException {
		StringBuilder url = new StringBuilder(apiConfig.hostName + apiConfig.path);
		params.put("ak", AK);

		// 判断AK校验方式
		if (SK != null && !"".equals(SK)) {
			// 设置sn后timestamp必填，以秒为单位
			params.put("timestamp", String.valueOf(Instant.now().getEpochSecond()));
			// 设置SN
			params.put("sn", SnCalHelper.getSn(url.toString(), params, SK));
		}

		// 拼接请求参数，并做UTF-8的编码
		for (Map.Entry<String, String> entry : params.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			url.append('&').append(key).append("=");
			try {
				url.append(URLEncoder.encode(value, "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				// This should never happen. UTF-8 support is required for every Java implementation.
				throw new IllegalStateException(e);
			}
		}

		Request request = new Request.Builder()
				.url(url.toString())
				.build();

		Response response = client.newCall(request).execute();
		R ps = null;
		if (response.isSuccessful()) {
			//如果请求成功，通知Handler更新数据
			String res = response.body().string();
			ps = gs.fromJson(res, clazz);
		}

		return ps;
	}

	public void setSK(String SK) {
		this.SK = SK;
	}
}
