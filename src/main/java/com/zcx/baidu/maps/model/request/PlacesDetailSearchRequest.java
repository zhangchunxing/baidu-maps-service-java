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
public class PlacesDetailSearchRequest extends PendingResultBase<PlacesDetailSearchRequest> {

	private static final ApiConfig API_CONFIG = new ApiConfig("/place/v2/detail?output=json")
			.fieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);

	public PlacesDetailSearchRequest(GeoApiContext context) {
		super(context, API_CONFIG, PlaceDetailResponse.class);
	}

	public PlacesDetailSearchRequest uid(String uid) {
		return param("uid", uid);
	}

	public PlacesDetailSearchRequest uids(String uids) {
		return param("uid", uids);
	}

	public PlacesDetailSearchRequest scope(ScopeEnum scope) {
		return param("scope", scope);
	}

	public PlacesDetailSearchRequest timestamp(long timestamp) {
		return param("timestamp", timestamp);
	}

}
