package com.zcx.baidu.maps.model.response;

import com.zcx.baidu.maps.model.BaseApiResponse;

/**
 * @description: 地点检索API请求结果的响应
 * @author: zhangchunxing
 * @create: 2018-11-03
 **/
public class PlacesSearchResponse extends BaseApiResponse {

    /** 地点检索请求的结果集 */
    public PlacesSearchResult results[];
}
