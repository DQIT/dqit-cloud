package top.dqit.cloud.system.user.exception;

import top.dqit.common.constants.ErrorCode;
import top.dqit.common.exception.BizException;

/**
 * 用户操作异常
 * @author mr_hqing@163.com
 * @since 2022/3/13
 */
public class UserOperationException extends BizException {
	
	public UserOperationException(ErrorCode errorCode) {
		super(errorCode);
	}
}
