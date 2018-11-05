package com.zcx.baidu.maps.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Map;

/**
 * @description: sn计算辅助
 * @author: zhangchunxing
 * @create: 2018-10-27
 **/
public final class SnCalHelper {

	private static final String AK = "x1yHzp8dMcnylGh1UbWNlqkad8MafGBq";
	private static final String SK = "4EOhUAvNHmEcAj15xBEFY08BLzPNOnIV";

	private SnCalHelper() {
	}


	/**
	 *
	 * @param uri
	 * @param paramsMap LinkedHashMap
	 * @return
	 */
	public static String getSn(String uri, Map paramsMap) {

		try {
			paramsMap.put("ak", AK);
			// 调用下面的toQueryString方法，
			// 对LinkedHashMap内所有value作utf8编码
			String paramsStr = toQueryString(paramsMap);

			String wholeStr = uri + "?" + paramsStr + SK;

			// 对上面wholeStr再作utf8编码
			String tempStr = URLEncoder.encode(wholeStr, "UTF-8");

			// 调用下面的MD5方法得到最后的sn签名
			return MD5(tempStr);
		} catch (UnsupportedEncodingException e) {
			// 未处理
		}
		return null;
	}

	// 对Map内所有value作utf8编码，拼接返回结果
	private static String toQueryString(Map<?, ?> data) throws UnsupportedEncodingException {
		StringBuffer queryString = new StringBuffer();
		for (Map.Entry<?, ?> pair : data.entrySet()) {
			queryString.append(pair.getKey() + "=");
			String ss[] = pair.getValue().toString().split(",");
			if (ss.length > 1) {
				for (String s : ss) {
					queryString.append(URLEncoder.encode(s, "UTF-8") + ",");
				}
				queryString.deleteCharAt(queryString.length() - 1);
				queryString.append("&");
			} else {
				queryString.append(URLEncoder.encode((String) pair.getValue(),
						"UTF-8") + "&");
			}
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
