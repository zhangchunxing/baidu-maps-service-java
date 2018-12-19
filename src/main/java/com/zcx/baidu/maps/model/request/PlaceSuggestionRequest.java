package com.zcx.baidu.maps.model.request;

import com.google.gson.FieldNamingPolicy;
import com.zcx.baidu.maps.common.ApiConfig;
import com.zcx.baidu.maps.common.GeoApiContext;
import com.zcx.baidu.maps.model.PendingResultBase;
import com.zcx.baidu.maps.model.response.PlaceSuggestionResponse;

/**
 * @description: 地点输入提示服务请求
 * @author: zhangchunxing
 * @create: 2018-12-19
 **/
public class PlaceSuggestionRequest<T extends PlaceSuggestionRequest>
        extends PendingResultBase<T, PlaceSuggestionResponse> {

    private static final ApiConfig API_CONFIG = new ApiConfig("/place/v2/suggestion?output=json")
            .fieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);

    public PlaceSuggestionRequest(GeoApiContext context, Class<PlaceSuggestionResponse> clazz) {
        super(context, API_CONFIG, clazz);
    }



}
