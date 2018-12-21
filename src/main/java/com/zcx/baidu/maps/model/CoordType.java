package com.zcx.baidu.maps.model;

/**
 * @description: 坐标类型:
 *                  1（WGS84ll即GPS经纬度）
 *                  2（GCJ02ll即国测局经纬度坐标）
 *                  3（BD09ll即百度经纬度坐标）
 *                  4（BD09mc即百度米制坐标）
 * @author: zhangchunxing
 * @create: 2018-12-21
 */
public enum  CoordType {

	WGS84ll(1), GCJ02ll(2), BD09ll(3), BD09mc(4);

	private int code;

	CoordType(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
