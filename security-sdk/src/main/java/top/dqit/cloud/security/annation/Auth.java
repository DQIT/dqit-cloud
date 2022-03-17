package top.dqit.cloud.security.annation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 登录身份验证
 * @author mr_hqing@163.com
 * @since 2022/3/16
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Auth {
	
	/**
	 * 是否需要身份验证
	 */
	boolean check() default true;
	
	/**
	 * 权限验证
	 */
	String[] hasRoles() default {};
	
}
