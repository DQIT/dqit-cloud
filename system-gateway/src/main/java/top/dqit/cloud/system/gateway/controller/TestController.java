package top.dqit.cloud.system.gateway.controller;

import top.dqit.common.model.Result;
import top.dqit.cloud.api.system.user.SystemUserApi;
import top.dqit.cloud.system.user.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mr_hqing@163.com
 * @since 2022/3/14
 */

@RestController
public class TestController {
	
	@Autowired
	private SystemUserApi systemUserApi;
	
	@GetMapping("/openFeignTest")
	public Result<UserInfo> test(){
		Result<UserInfo> result = systemUserApi.getCurrentUserInfo("admin");
		return result;
	}
	
}
