package com.zcx.baidu.maps.api;


import com.zcx.baidu.maps.common.GeoApiContext;
import com.zcx.baidu.maps.model.DistrictRegionSearchRequest;

/**
 * @description： 地点检索服务
 * @author: zhangchunxing
 * @create: 2018-10-26
 **/
public class PlaceApi {

    private PlaceApi() {}

    /**
     * 行政区划区域检索
     *
     * @param context
     * @param query 检索关键字
     * @param region 检索行政区划区域
     * @return
     */
    public static DistrictRegionSearchRequest districtRegionSearchQuery(GeoApiContext context,String query,
                                                                        String region) {

        DistrictRegionSearchRequest request = new DistrictRegionSearchRequest(context);
        request.query(query);
        request.region(region);
        return request;
    }




}
