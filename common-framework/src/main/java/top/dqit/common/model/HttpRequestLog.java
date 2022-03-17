package top.dqit.common.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.Map;

/**
 * http请求日志
 * @author mr_hqing@163.com
 * @since 2022/3/16
 */
@Data
@Accessors(chain = true)
public class HttpRequestLog {
	/**
	 * 请求地址
	 */
	private String url;
	/**
	 * 最后一个代理的 Internet 协议 (IP) 地址
	 */
	private String remoteAddress;
	/**
	 * 参数
	 */
	private Map<String, Object> param;
	/**
	 * 耗时 ms
	 */
	private long timeMillis;
}
