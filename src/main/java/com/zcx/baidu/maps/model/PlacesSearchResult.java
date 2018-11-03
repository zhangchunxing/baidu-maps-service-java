package com.zcx.baidu.maps.model;

import java.io.Serializable;

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
}
