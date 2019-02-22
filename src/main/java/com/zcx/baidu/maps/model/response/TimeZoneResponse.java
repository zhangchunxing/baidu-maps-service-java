package com.zcx.baidu.maps.model.response;


import com.zcx.baidu.maps.model.ApiResponse;

/**
 * @description: 时区
 * @author: zhangchunxing
 * @create: 2018-11-21
 */
public class TimeZoneResponse extends ApiResponse {
    /**
     * 请求位置的实际时间=传入的timestamp + dst_offset + raw_offset
     */

    public String timezone_id; // 所在时区ID字符串
    public int dst_offset; // 夏令时(Daylight Saving Time：DST)时间偏移秒数
    public int raw_offset; // 坐标点位置时间较协调世界时偏移秒数

}
