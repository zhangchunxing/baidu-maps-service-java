package com.zcx.baidu.maps.model.request;

import com.google.gson.FieldNamingPolicy;
import com.zcx.baidu.maps.common.ApiConfig;
import com.zcx.baidu.maps.common.GeoApiContext;
import com.zcx.baidu.maps.model.CoordType;
import com.zcx.baidu.maps.model.LatLng;
import com.zcx.baidu.maps.model.PendingResultBase;
import com.zcx.baidu.maps.model.response.GeocodingResponse;

/**
 * @description: ${DESCRIPTION}
 * @author: zhangchunxing
 * @create: 2018-12-24
 */
public class GeocodingRequest extends PendingResultBase<GeocodingRequest, GeocodingResponse> {

	private static final ApiConfig API_CONFIG = new ApiConfig("/geocoder/v2/?output=json")
			.fieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);

	public GeocodingRequest(GeoApiContext context) {
		super(context, API_CONFIG, GeocodingResponse.class);
	}

	public GeocodingRequest location(LatLng location) {
		return param("location", location);
	}

	public GeocodingRequest address(String address) {
		return param("address", address);
	}

	public GeocodingRequest city(String city) {
		return param("city", city);
	}

	public GeocodingRequest retCoordtype(CoordType coordType) {
		return param("ret_coordtype", coordType);
	}

	public GeocodingRequest coordtype(CoordType coordType) {
		return param("coordtype", coordType);
	}

	/**
	 * 是否召回传入坐标周边的poi，0为不召回，1为召回。
	 * @param called
	 * @return
	 */
	public GeocodingRequest pois(int called) {
		return param("pois", called);
	}

	public GeocodingRequest radius(int radius) {
		return param("radius", radius);
	}

}
