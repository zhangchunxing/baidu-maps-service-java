package com.zcx.baidu.maps.model.response;

import com.zcx.baidu.maps.model.BaseApiResponse;
import com.zcx.baidu.maps.model.LatLng;

import java.util.List;

/**
 * @description: 地点检索服务返回结果
 * @author: zhangchunxing
 * @create: 2018-12-20
 **/
public class PlaceSuggestionResponse extends BaseApiResponse {

    public List<PlaceInfo> result;

    static class PlaceInfo   {

        public String name;
        public LatLng location;
        public String uid;
        public String province;
        public String city;
        public String district; // 区县
        public String business; // 暂无信息
        public String cityid;   //

    }
}
