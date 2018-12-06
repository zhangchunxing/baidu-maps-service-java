package com.zcx.baidu.maps.model.request;

import com.google.gson.FieldNamingPolicy;
import com.zcx.baidu.maps.common.ApiConfig;
import com.zcx.baidu.maps.common.GeoApiContext;
import com.zcx.baidu.maps.model.PendingResultBase;
import com.zcx.baidu.maps.model.ScopeEnum;
import com.zcx.baidu.maps.model.response.PlaceDetailResponse;

/**
 * @description: 地点详情检索
 * @author: zhangchunxing
 * @create: 2018-12-05
 */
public class PlaceDetailsRequest extends PendingResultBase<PlaceDetailsRequest, PlaceDetailResponse> {

	private static final ApiConfig API_CONFIG = new ApiConfig("/place/v2/detail?output=json")
			.fieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);

	public PlaceDetailsRequest(GeoApiContext context) {
		super(context, API_CONFIG, PlaceDetailResponse.class);
	}

	public PlaceDetailsRequest uid(String uid) {
		return param("uid", uid);
	}

	public PlaceDetailsRequest uids(String uids) {
		return param("uid", uids);
	}

	public PlaceDetailsRequest scope(ScopeEnum scope) {
		return param("scope", scope);
	}

	public PlaceDetailsRequest timestamp(long timestamp) {
		return param("timestamp", timestamp);
	}

}
