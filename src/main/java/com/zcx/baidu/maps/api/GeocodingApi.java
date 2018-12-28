package com.zcx.baidu.maps.api;

import com.zcx.baidu.maps.common.GeoApiContext;
import com.zcx.baidu.maps.model.LatLng;
import com.zcx.baidu.maps.model.request.GeocodingRequest;

/**
 * @description: 提供地理编码服务
 * @author: zhangchunxing
 * @create: 2018-12-24
 */
public class GeocodingApi {
	private GeocodingApi() {}


	public static GeocodingRequest geocode(GeoApiContext context, String address) {
		GeocodingRequest request = new GeocodingRequest(context);
		request.address(address);
		return request;
	}

	public static GeocodingRequest reverseGeocode(GeoApiContext context, LatLng location) {
		GeocodingRequest request = new GeocodingRequest(context);
		request.location(location);
		return request;
	}


}
