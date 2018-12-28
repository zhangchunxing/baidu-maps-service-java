package com.zcx.baidu.maps.api;

import com.zcx.baidu.maps.common.GeoApiContext;
import com.zcx.baidu.maps.model.request.PlaceSuggestionRequest;

/**
 * @description: 地点输入提示服务。
 * @author: zhangchunxing
 * @create: 2018-12-19
 **/
public class PlaceSuggestionApi {

    private PlaceSuggestionApi() {}

    public static PlaceSuggestionRequest placeSuggestion(GeoApiContext context, String query, String region) {
        PlaceSuggestionRequest request = new PlaceSuggestionRequest(context);
        request.query(query);
        request.region(region);
        return request;
    }

}
