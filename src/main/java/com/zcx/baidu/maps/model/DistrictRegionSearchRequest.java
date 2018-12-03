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

	public DistrictRegionSearchRequest region(String region) {
		return param("region", region);
	}

	public DistrictRegionSearchRequest cityLimit(boolean limited) {
		return param("city_limit", limited);
	}


}
