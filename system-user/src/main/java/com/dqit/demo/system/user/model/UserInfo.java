package com.dqit.demo.system.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author HuangQing
 * @since 2022/3/12
 */
@ApiModel(value = "UserInfo")
@Data
public class UserInfo {
	@ApiModelProperty(value = "姓名", example = "张三")
	private String name;
	@ApiModelProperty(value = "出生日期", example = "2022-01-01")
	private LocalDate bornDate;
	@ApiModelProperty(value = "性别", example = "true")
	private Boolean gender;
}
