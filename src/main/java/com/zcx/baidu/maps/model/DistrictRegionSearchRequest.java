package com.zcx.baidu.maps.model;

import com.google.gson.FieldNamingPolicy;
import com.zcx.baidu.maps.common.ApiConfig;
import com.zcx.baidu.maps.common.GeoApiContext;

import java.io.IOException;
import java.util.LinkedHashMap;

/**
 * @description: 行政区域检索请求
 * @author: zhangchunxing
 * @create: 2018-11-05
 */
public class DistrictRegionSearchRequest {

	private ApiConfig API_CONFIG = new ApiConfig("/place/v2/search?output=json")
			.fieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);

	private GeoApiContext context;

	// 存放查询条件
	private LinkedHashMap<String, String> params = new LinkedHashMap<>();


	public DistrictRegionSearchRequest(GeoApiContext context) {
		this.context = context;
	}

	public DistrictRegionSearchRequest query(String placeName) {
		params.put("query", placeName);
		return this;
	}

	public DistrictRegionSearchRequest tag(String tag) {
		params.put("tag", tag);
		return this;
	}

	public DistrictRegionSearchRequest region(String region) {
		params.put("region", region);
		return this;
	}

	public PlacesSearchResponse makeRequest() throws IOException {
		return context.get(API_CONFIG, params);
	}


}
