package com.dqit.demo.system.user.controller;

import com.dqit.common.model.Result;
import com.dqit.demo.system.user.model.RegisterForm;
import com.dqit.demo.system.user.model.UserInfo;
import com.dqit.demo.system.user.model.entity.SystemUser;
import com.dqit.demo.system.user.repository.SystemUserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

/**
 * @author HuangQing
 * @since 2022/3/12
 */
@Api(tags = {"系统-用户"})
@RestController
public class SystemUserController {
	@Autowired
	private SystemUserRepository systemUserRepository;
	
	@ApiOperation(value = "获取当前用户信息")
	@GetMapping("/getCurrentUserInfo")
	public Result<UserInfo> getCurrentUserInfo(){
		Optional<SystemUser> optional = systemUserRepository.findById(1L);
		UserInfo userInfo = new UserInfo();
		optional.ifPresent(systemUser -> BeanUtils.copyProperties(systemUser, userInfo));
		return Result.success(userInfo);
	}
	
	@ApiOperation(value = "注册")
	@PostMapping("/register")
	public Result<String> register(@Valid @RequestBody RegisterForm registerForm){
		return Result.success();
	}

	
}
