package top.dqit.common.exception;

import top.dqit.common.constants.ErrorCode;
import lombok.Getter;
import lombok.Setter;

/**
 * 正常业务异常
 * @author mr_hqing@163.com
 * @since 2022/3/13
 */
@Setter
@Getter
public abstract class BizException extends RuntimeException{
	private ErrorCode errorCode;
	
	public BizException(ErrorCode errorCode){
		this.errorCode = errorCode;
	}
}
