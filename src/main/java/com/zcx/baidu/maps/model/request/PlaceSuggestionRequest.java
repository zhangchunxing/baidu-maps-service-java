package com.zcx.baidu.maps.model.request;

import com.google.gson.FieldNamingPolicy;
import com.zcx.baidu.maps.common.ApiConfig;
import com.zcx.baidu.maps.common.GeoApiContext;
import com.zcx.baidu.maps.model.CoordType;
import com.zcx.baidu.maps.model.LatLng;
import com.zcx.baidu.maps.model.PendingResultBase;
import com.zcx.baidu.maps.model.response.PlaceSuggestionResponse;

/**
 * @description: 地点输入提示服务请求
 * @author: zhangchunxing
 * @create: 2018-12-19
 **/
public class PlaceSuggestionRequest extends PendingResultBase<PlaceSuggestionRequest, PlaceSuggestionResponse> {

    private static final ApiConfig API_CONFIG = new ApiConfig("/place/v2/suggestion?output=json")
            .fieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);

    public PlaceSuggestionRequest(GeoApiContext context) {
        super(context, API_CONFIG, PlaceSuggestionResponse.class);
    }

    public PlaceSuggestionRequest query(String placeName) {
        return param("query", placeName);
    }

    public PlaceSuggestionRequest region(String region) {
        return param("region", region);
    }

    public PlaceSuggestionRequest cityLimit(boolean limited) {
        return param("city_limit", limited);
    }

    public PlaceSuggestionRequest location(LatLng location) {
        return param("location", location);
    }

    public PlaceSuggestionRequest coordType(CoordType coordType) {
        return param("coord_type", coordType);
    }

    public PlaceSuggestionRequest retCoordType(CoordType coordType) {
        return param("ret_coordtype", coordType);
    }

	// public PlaceSuggestionRequest timestamp(long timestamp) {
	//     return param("timestamp", timestamp);
	// }

}
