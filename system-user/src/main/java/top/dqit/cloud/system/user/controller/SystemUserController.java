package top.dqit.cloud.system.user.controller;

import top.dqit.common.model.Result;
import top.dqit.cloud.security.annation.Auth;
import top.dqit.cloud.system.user.model.RegisterForm;
import top.dqit.cloud.system.user.model.UserInfo;
import top.dqit.cloud.system.user.model.entity.User;
import top.dqit.cloud.system.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * @author mr_hqing@163.com
 * @since 2022/3/12
 */
@Tag(name = "用户账户", description = "用户账户相关接口，如注册、查询用户信息")
@RestController
@RequestMapping("/user")
public class SystemUserController {
	@Autowired
	private UserService userService;
	
	@Operation(tags = {"用户账户"}, description = "获取当前用户信息")
	@GetMapping("/getCurrentUserInfo")
	@Auth
	public Result<UserInfo> getCurrentUserInfo(String loginName) {
		Optional<User> userOptional = userService.getUserByLoginName(loginName);
		UserInfo userInfo = new UserInfo();
		userOptional.ifPresent(user -> BeanUtils.copyProperties(user, userInfo));
		return Result.success(userInfo);
	}
	
	@Operation(tags = {"用户账户"}, description = "注册")
	@PostMapping("/register")
	public Result<?> register(@Valid @RequestBody RegisterForm registerForm) {
		userService.register(registerForm);
		return Result.success();
	}
	
	
}
