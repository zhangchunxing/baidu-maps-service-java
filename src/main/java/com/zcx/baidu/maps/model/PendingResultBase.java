package com.zcx.baidu.maps.model;

import com.zcx.baidu.maps.common.ApiConfig;
import com.zcx.baidu.maps.common.GeoApiContext;

import java.io.IOException;
import java.util.LinkedHashMap;

/**
 * @description:
 * @author: zhangchunxing
 * @create: 2018-12-03
 */
public abstract class PendingResultBase<A extends PendingResultBase> {
	private final GeoApiContext context;
	private final ApiConfig config;

	private Class<? extends BaseApiResponse> responseClass;
	// 存放查询条件
	private LinkedHashMap<String, String> params = new LinkedHashMap<>();

	protected PendingResultBase(GeoApiContext context, ApiConfig config, Class<? extends BaseApiResponse> clazz) {
		this.context = context;
		this.config = config;
		this.responseClass = clazz;
	}

	public BaseApiResponse makeRequest() throws IOException {
		return context.get(config, params, responseClass);
	}

	protected A param(String key, String value) {
		params.put(key, value);
		return getInstance();
	}

	protected A param(String key, ScopeEnum scope) {
		params.put(key, String.valueOf(scope.getCode()));
		return getInstance();
	}


	protected A param(String key, long value) {
		params.put(key, String.valueOf(value));
		return getInstance();
	}

	protected A param(String key, boolean value) {
		params.put(key, String.valueOf(value));
		return getInstance();
	}

	private A getInstance() {
		A result = (A) this;
		return result;
	}
}
