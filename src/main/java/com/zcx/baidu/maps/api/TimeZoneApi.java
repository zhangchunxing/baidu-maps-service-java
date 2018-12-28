package com.zcx.baidu.maps.api;

import com.zcx.baidu.maps.common.GeoApiContext;
import com.zcx.baidu.maps.model.LatLng;
import com.zcx.baidu.maps.model.request.TimeZoneRequest;

import java.time.Instant;

/**
 * @description: 时区请求服务接口
 * @author: zhangchunxing
 * @create: 2018-12-28
 */
public class TimeZoneApi {


	private TimeZoneApi() {}

	public static TimeZoneRequest timeZoneQuery(GeoApiContext context, LatLng location) {
		TimeZoneRequest request = new TimeZoneRequest(context);
		request.location(location);
		request.timestamp(Instant.now().getEpochSecond());
		return request;
	}
}
