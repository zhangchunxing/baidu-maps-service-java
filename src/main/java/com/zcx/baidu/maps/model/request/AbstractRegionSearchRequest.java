package com.zcx.baidu.maps.model.request;

import com.google.gson.FieldNamingPolicy;
import com.zcx.baidu.maps.common.ApiConfig;
import com.zcx.baidu.maps.common.GeoApiContext;
import com.zcx.baidu.maps.model.PendingResultBase;
import com.zcx.baidu.maps.model.ScopeEnum;
import com.zcx.baidu.maps.model.response.PlacesSearchResponse;

/**
 * @description: 区域检索请求基类
 * @author: zhangchunxing
 * @create: 2018-12-03
 **/
public abstract class AbstractRegionSearchRequest<T extends AbstractRegionSearchRequest>
        extends PendingResultBase<T, PlacesSearchResponse> {

    private static final ApiConfig API_CONFIG = new ApiConfig("/place/v2/search?output=json")
            .fieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);

    public AbstractRegionSearchRequest(GeoApiContext context) {
        super(context, API_CONFIG, PlacesSearchResponse.class);
    }

    public T query(String placeName) {
        return param("query", placeName);
    }

    public T tag(String tag) {
        return param("tag", tag);
    }

    public T scope(ScopeEnum scope) {
        return param("scope", scope);
    }

	// public T timestamp(long timestamp) {
	//     return param("timestamp", timestamp);
	// }

}
