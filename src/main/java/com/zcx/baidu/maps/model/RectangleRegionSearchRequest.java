package com.zcx.baidu.maps.model;

import com.google.gson.FieldNamingPolicy;
import com.zcx.baidu.maps.common.ApiConfig;
import com.zcx.baidu.maps.common.GeoApiContext;

import java.io.IOException;
import java.util.LinkedHashMap;

/**
 * @description: 矩形区域检索请求
 * @author: zhangchunxing
 * @create: 2018-12-03
 */
public class RectangleRegionSearchRequest {

	static final ApiConfig API_CONFIG = new ApiConfig("/place/v2/search?output=json")
			.fieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);

	private final GeoApiContext context;

	// 存放查询条件
	private LinkedHashMap<String, String> params = new LinkedHashMap<>();


	public RectangleRegionSearchRequest(GeoApiContext context) {
		this.context = context;
	}

	public RectangleRegionSearchRequest query(String placeName) {
		params.put("query", placeName);
		return this;
	}

	public RectangleRegionSearchRequest tag(String tag) {
		params.put("tag", tag);
		return this;
	}

	/**
	 * 检索矩形区域
	 * @param leftDownPoint 左下角坐标
	 * @param rightUpPoint 右上角坐标
	 * @return
	 */
	public RectangleRegionSearchRequest bounds(LatLng leftDownPoint, LatLng rightUpPoint) {
		String bounds = leftDownPoint.toString() + "," + rightUpPoint.toString();
		params.put("bounds", bounds);
		return this;
	}

	public RectangleRegionSearchRequest scope(PoiInfoEnum poiInfoEnum) {
		String scope = String.valueOf(poiInfoEnum.getCode());
		params.put("scope", scope);
		return this;
	}

	public RectangleRegionSearchRequest timestamp(long timestamp) {
		String toString = String.valueOf(timestamp);
		params.put("timestamp", toString);
		return this;
	}

	public PlacesSearchResponse makeRequest() throws IOException {
		return context.get(API_CONFIG, params);
	}
}
