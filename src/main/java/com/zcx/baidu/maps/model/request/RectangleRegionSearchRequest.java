package com.zcx.baidu.maps.model.request;

import com.zcx.baidu.maps.common.GeoApiContext;
import com.zcx.baidu.maps.model.LatLng;

/**
 * @description: 矩形区域检索请求
 * @author: zhangchunxing
 * @create: 2018-12-03
 */
public class RectangleRegionSearchRequest extends AbstractRegionSearchRequest<RectangleRegionSearchRequest> {

	public RectangleRegionSearchRequest(GeoApiContext context) {
		super(context);
	}

	/**
	 * 检索矩形区域
	 * @param leftDownPoint 左下角坐标
	 * @param rightUpPoint 右上角坐标
	 * @return
	 */
	public RectangleRegionSearchRequest bounds(LatLng leftDownPoint, LatLng rightUpPoint) {
		String bounds = leftDownPoint.toString() + "," + rightUpPoint.toString();
		return param("bounds", bounds);
	}

}
