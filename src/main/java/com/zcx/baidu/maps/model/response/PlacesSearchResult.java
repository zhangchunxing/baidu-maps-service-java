package com.zcx.baidu.maps.model.response;

import com.zcx.baidu.maps.model.LatLng;

import java.io.Serializable;
import java.util.List;

/**
 * @description: 地点检索请求的结果详情
 * @author: zhangchunxing
 * @create: 2018-11-03
 **/
public class PlacesSearchResult implements Serializable {
    private static final long serialVersionUID = 1L;

    public String name;

    // poi经纬度坐标
    public LatLng location;

    public String address;

    public String province;

    public String city;

    public String area;

    public String street_id;

    // 是否有详情页：1有，0没有
    public int detail;

    // poi的唯一标示
    public String uid;
    // poi的扩展信息，仅当scope=2时，显示该字段，不同的poi类型，显示的detail_info字段不同。
    public DetailInfo detail_info;

    private static class DetailInfo {
        public String tag;
        public LatLng navi_location;
        public String shop_hours;
        public String brand;
        public String detail_url;
        public String type;
        public String overall_rating;
        public String service_rating;
        public String environment_rating;
        public String image_num;
        public List<String> alias;

    }
}
