package com.zcx.baidu.maps.model.request;

import com.google.gson.FieldNamingPolicy;
import com.zcx.baidu.maps.common.ApiConfig;
import com.zcx.baidu.maps.common.GeoApiContext;
import com.zcx.baidu.maps.model.CoordType;
import com.zcx.baidu.maps.model.LatLng;
import com.zcx.baidu.maps.model.PendingResultBase;
import com.zcx.baidu.maps.model.response.TimeZoneResponse;

/**
 * @description: 时区查询
 * @author: zhangchunxing
 * @create: 2018-12-28
 */
public class TimeZoneRequest extends PendingResultBase<TimeZoneRequest, TimeZoneResponse> {
	private static final ApiConfig API_CONFIG = new ApiConfig("/timezone/v1?output=json")
			.fieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);

	public TimeZoneRequest(GeoApiContext context) {
		super(context, API_CONFIG, TimeZoneResponse.class);
	}

	public TimeZoneRequest location(LatLng location) {
		return param("location", location);
	}

	public TimeZoneRequest coordType(CoordType coordType) {
		return param("coordType", coordType.name());
	}

	public TimeZoneRequest timestamp(long timestamp) {
		return param("timestamp", timestamp);
	}
}
