package com.zcx.baidu.maps.model;

import com.google.gson.FieldNamingPolicy;
import com.zcx.baidu.maps.common.ApiConfig;
import com.zcx.baidu.maps.common.GeoApiContext;

import java.util.LinkedHashMap;

/**
 * @description: 圆形区域检索
 * @author: zhangchunxing
 * @create: 2018-11-14
 */
public class CircularRegionSearchRequest {
	static final ApiConfig API_CONFIG = new ApiConfig("/place/v2/search?output=json")
			.fieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);

	private final GeoApiContext context;

	// 存放查询条件
	private LinkedHashMap<String, String> params = new LinkedHashMap<>();

	public CircularRegionSearchRequest(GeoApiContext context) {
		this.context = context;
	}

	public CircularRegionSearchRequest query(String placeName) {
		params.put("query", placeName);
		return this;
	}

	public CircularRegionSearchRequest tag(String tag) {
		params.put("tag", tag);
		return this;
	}

	public CircularRegionSearchRequest location(LatLng latLng) {
		String location = latLng.toString();
		params.put("location", location);
		return this;
	}

	public CircularRegionSearchRequest radiusLimit(boolean limited0) {
		String limited = String.valueOf(limited0);
		params.put("limited", limited   );
		return this;
	}
}
