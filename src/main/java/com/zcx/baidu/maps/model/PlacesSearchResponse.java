package com.zcx.baidu.maps.model;

import java.io.Serializable;

/**
 * @description: 地点检索API请求结果的响应
 * @author: zhangchunxing
 * @create: 2018-11-03
 **/
public class PlacesSearchResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    // 本次API访问状态，如果成功返回0，如果失败返回其他数字。（见服务状态码）
    public int status;

    // 对API访问状态值的英文说明，如果成功返回"ok"，并返回结果字段，如果失败返回错误说明。
    public String message;

    /** 地点检索请求的结果集 */
    public PlacesSearchResult results[];
}
