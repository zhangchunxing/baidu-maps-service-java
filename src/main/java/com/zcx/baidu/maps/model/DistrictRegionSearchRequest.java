package com.zcx.baidu.maps.model;

import com.zcx.baidu.maps.common.GeoApiContext;

/**
 * @description: 行政区域检索请求
 * @author: zhangchunxing
 * @create: 2018-11-05
 */
public class DistrictRegionSearchRequest extends AbstractRegionSearchRequest<DistrictRegionSearchRequest> {

	public DistrictRegionSearchRequest(GeoApiContext context) {
		super(context);
	}

	public DistrictRegionSearchRequest query(String placeName) {
		return param("query", placeName);
	}

	public DistrictRegionSearchRequest tag(String tag) {
		params.put("tag", tag);
		return this;
	}

	public DistrictRegionSearchRequest region(String region) {
		params.put("region", region);
		return this;
	}

	public DistrictRegionSearchRequest cityLimit(boolean limited) {
		String city_limit = String.valueOf(limited);
		params.put("city_limit", city_limit);
		return this;
	}
	public DistrictRegionSearchRequest scope(PoiInfoEnum poiInfoEnum) {
		String scope = String.valueOf(poiInfoEnum.getCode());
		params.put("scope", scope);
		return this;
	}
	public DistrictRegionSearchRequest timestamp(long timestamp) {
		String toString = String.valueOf(timestamp);
		params.put("timestamp", toString);
		return this;
	}


}
