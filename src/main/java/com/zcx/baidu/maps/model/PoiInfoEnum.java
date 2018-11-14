package com.zcx.baidu.maps.model;

/**
 * @description: 地点检索，返回POI信息的详细程度。
 * 取值为1 或空，则返回基本信息；取值为2，返回检索POI详细信息
 * @author: zhangchunxing
 * @create: 2018-11-14
 */
public enum PoiInfoEnum {

	BASIC(1), DETAILED(2);

	private int code;

	PoiInfoEnum(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
}
