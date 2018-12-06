package com.zcx.baidu.maps.api;


import com.zcx.baidu.maps.common.GeoApiContext;
import com.zcx.baidu.maps.model.LatLng;
import com.zcx.baidu.maps.model.request.CircularRegionSearchRequest;
import com.zcx.baidu.maps.model.request.DistrictRegionSearchRequest;
import com.zcx.baidu.maps.model.request.PlaceDetailsRequest;
import com.zcx.baidu.maps.model.request.RectangleRegionSearchRequest;

/**
 * @description： 地点检索服务
 * @author: zhangchunxing
 * @create: 2018-10-26
 **/
public final class PlacesApi {

    private PlacesApi() {}

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

    /**
     *
     * @param context
     * @param query 检索关键字
     * @param location 圆形区域检索中心点
     * @return
     */
    public static CircularRegionSearchRequest circularRegionSearchQuery(GeoApiContext context, String query,
                                                                        LatLng location) {

        CircularRegionSearchRequest request = new CircularRegionSearchRequest(context);
        request.query(query);
        request.location(location);
        return request;
    }

    /**
     * 矩形区域检索中心点
     * @param context
     * @param query 检索关键字
     * @param leftDown 左下角
     * @param rightUp 右上角
     * @return
     */
    public static RectangleRegionSearchRequest rectangleRegionSearchQuery(GeoApiContext context, String query,
                                                                         LatLng leftDown, LatLng rightUp) {

        RectangleRegionSearchRequest request = new RectangleRegionSearchRequest(context);
        request.query(query);
        request.bounds(leftDown, rightUp);
        return request;
    }

    public static PlaceDetailsRequest placeDetails(GeoApiContext context, String uid) {
        PlaceDetailsRequest request = new PlaceDetailsRequest(context);
        request.uid(uid);
        return request;
    }




}
