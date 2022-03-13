package com.dqit.demo.system.user.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @author HuangQing
 * @since 2022/3/12
 */
@Data
public class RegisterForm {
	@NotEmpty(message = "name必填")
	private String name;
	
	@Size(min = 5, max = 10, message = "desc为5-10个字符")
	private String desc;
}
