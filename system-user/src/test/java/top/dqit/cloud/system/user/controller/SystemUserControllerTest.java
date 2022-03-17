package top.dqit.cloud.system.user.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import top.dqit.cloud.system.user.model.RegisterForm;
import top.dqit.cloud.system.user.model.UserInfo;
import top.dqit.common.model.Result;

/**
 * SystemUserController单元测试
 *
 * @author mr_hqing@163.com
 * @since 2022/3/17
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SystemUserControllerTest {
	
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	/**
	 * TEST: /user/register
	 * {@link top.dqit.cloud.system.user.controller.SystemUserController#register(RegisterForm)}
	 */
	@Test
	public void registerTest() {
		String url = "/user/register";
		String param = "{\"loginName\": \"test-user2\", \"loginPassword\": \"test-password\"}";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> httpEntity = new HttpEntity<>(param, headers);
		ResponseEntity<Result> responseEntity = testRestTemplate.postForEntity(url, httpEntity, Result.class);
		Assertions.assertNotNull(responseEntity);
		Result<Object> body = responseEntity.getBody();
		Assert.assertNotNull(body);
		Assert.assertTrue(body.getSuccess());
	}
	
	/**
	 * TEST: /user/getCurrentUserInfo
	 * {@link top.dqit.cloud.system.user.controller.SystemUserController#getCurrentUserInfo(String)}
	 */
	@Test
	public void getCurrentUserInfoTest() {
		String url = "/user/getCurrentUserInfo?loginName={1}";
		String param = "test-user";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		ResponseEntity<Result> responseEntity = testRestTemplate.getForEntity(url, Result.class, param);
		Assertions.assertNotNull(responseEntity);
		Result<UserInfo> body = responseEntity.getBody();
		Assertions.assertNotNull(body);
	}
	
}
