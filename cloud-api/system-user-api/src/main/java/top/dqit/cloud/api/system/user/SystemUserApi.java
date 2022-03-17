package top.dqit.cloud.api.system.user;

import top.dqit.common.model.Result;
import top.dqit.cloud.system.user.model.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "system-user")
public interface SystemUserApi {
	@GetMapping(value = "/user/getCurrentUserInfo")
	Result<UserInfo> getCurrentUserInfo(@RequestParam("loginName") String loginName);
}
