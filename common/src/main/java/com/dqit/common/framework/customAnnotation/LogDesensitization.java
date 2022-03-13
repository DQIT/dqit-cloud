package com.dqit.common.framework.customAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * //TODO 日志脱敏
 * 标记需要进行日志脱敏的字段
 * @author HuangQing
 * @since 2022/3/12
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogDesensitization {
}
