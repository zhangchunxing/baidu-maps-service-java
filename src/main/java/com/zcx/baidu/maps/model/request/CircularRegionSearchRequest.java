package com.zcx.baidu.maps.model.request;

import com.zcx.baidu.maps.common.GeoApiContext;
import com.zcx.baidu.maps.model.LatLng;


/**
 * @description: 圆形区域检索
 * @author: zhangchunxing
 * @create: 2018-11-14
 */
public class CircularRegionSearchRequest extends AbstractRegionSearchRequest<CircularRegionSearchRequest> {

	public CircularRegionSearchRequest(GeoApiContext context) {
		super(context);
	}


	public CircularRegionSearchRequest location(LatLng latLng) {
		return param("location", latLng.toString());
	}

	public CircularRegionSearchRequest radiusLimit(boolean limited) {
		return param("limited", limited);
	}

}
