package com.zcx.baidu.maps.model;

import com.google.gson.FieldNamingPolicy;
import com.zcx.baidu.maps.common.ApiConfig;
import com.zcx.baidu.maps.common.GeoApiContext;

import java.io.IOException;
import java.util.LinkedHashMap;

/**
 * @description: 区域检索请求
 * @author: zhangchunxing
 * @create: 2018-12-03
 */
public class AbstractRegionSearchRequest<A extends AbstractRegionSearchRequest> {
	static final ApiConfig API_CONFIG = new ApiConfig("/place/v2/search?output=json")
			.fieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);

	private final GeoApiContext context;
	// 存放查询条件
	private LinkedHashMap<String, String> params = new LinkedHashMap<>();

	protected AbstractRegionSearchRequest(GeoApiContext context) {
		this.context = context;
	}

	public PlacesSearchResponse makeRequest() throws IOException {
		return context.get(API_CONFIG, params);
	}

	protected A param(String key, String value) {
		params.put(key, value);
		return getInstance();
	}

	protected A param(String key, PoiInfoEnum poiInfoEnum) {
		params.put(key, String.valueOf(poiInfoEnum.getCode()));
		return getInstance();
	}


	protected A param(String key, long value) {
		params.put(key, String.valueOf(value));
		return getInstance();
	}

	private A getInstance() {
		A result = (A) this;
		return result;
	}
}
