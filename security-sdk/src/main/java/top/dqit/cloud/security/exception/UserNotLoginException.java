package top.dqit.cloud.security.exception;

/**
 * 用户未登录异常
 *
 * @author mr_hqing@163.com
 * @since 2022/3/16
 */
public class UserNotLoginException extends AuthException {
	private final String message = "用户未登录";
}
