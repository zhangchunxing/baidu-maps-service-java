package com.zcx.baidu.maps.model.response;

import com.zcx.baidu.maps.model.LatLng;

/**
 * @description: 地理编码返回结果
 * @author: zhangchunxing
 * @create: 2018-12-24
 */
public class GeocodingResult {

	public LatLng location;
	// 位置的附加信息，是否精确查找。1为精确查找，即准确打点；0为不精确，即模糊打点。
	public int precise;
	// 地址理解程度。分值范围0-100，分值越大，服务对地址理解程度越高（建议以该字段作为解析结果判断标准）；
	public int comprehension;
	// 能精确理解的地址类型
	public String level;

	public String formatted_address;
	public String business;

	public AddressComponent addressComponent;
	// 当前位置结合POI的语义化结果描述。
	public String sematic_description;
	// 百度定义的城市id（正常更新与维护，但建议使用adcode）
	public int cityCode;



}
