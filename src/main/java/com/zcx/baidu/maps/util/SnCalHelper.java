package com.zcx.baidu.maps.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @description: sn计算辅助
 * @author: zhangchunxing
 * @create: 2018-10-27
 **/
public final class SnCalHelper {


    private SnCalHelper() {}

    public static void main(String[] args) {

        Map paramsMap = new LinkedHashMap<String, String>();
        paramsMap.put("address", "百度大厦");
        paramsMap.put("output", "json");
        paramsMap.put("ak", "yourak");
        snCal(paramsMap, "x1yHzp8dMcnylGh1UbWNlqkad8MafGBq");

    }

    // 计算sn跟参数对出现顺序有关，
    // get请求请使用LinkedHashMap保存<key,value>，
    // 该方法根据key的插入顺序排序；post请使用TreeMap保存<key,value>，
    // 该方法会自动将key按照字母a-z顺序排序。
    // 所以get请求可自定义参数顺序（sn参数必须在最后）发送请求，
    // 但是post请求必须按照字母a-z顺序填充body（sn参数必须在最后）。
    // 以get请求为例：http://api.map.baidu.com/geocoder/v2/?address=百度大厦&output=json&ak=yourak，
    // paramsMap中先放入address，再放output，然后放ak，放入顺序必须跟get请求中对应参数的出现顺序保持一致。
    public static String snCal(Map paramsMap, final String AK) {

        try {
            String paramsStr = toQueryString(paramsMap);
            String wholeStr = "/geocoder/v2/?" + paramsStr + AK;
            String tempStr = URLEncoder.encode(wholeStr, "UTF-8");

            return MD5(tempStr);
        } catch (UnsupportedEncodingException e) {
            // 未处理
        }
        return null;
    }

    // 对Map内所有value作utf8编码，拼接返回结果
    private static String toQueryString(Map<?, ?> data)
            throws UnsupportedEncodingException {
        StringBuffer queryString = new StringBuffer();
        for (Map.Entry<?, ?> pair : data.entrySet()) {
            queryString.append(pair.getKey() + "=");
            queryString.append(URLEncoder.encode((String) pair.getValue(),
                    "UTF-8") + "&");
        }
        if (queryString.length() > 0) {
            queryString.deleteCharAt(queryString.length() - 1);
        }
        return queryString.toString();
    }

    // 来自stackoverflow的MD5计算方法，调用了MessageDigest库函数，并把byte数组结果转换成16进制
    private static String MD5(String md5) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100), 1, 3);
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }

}
