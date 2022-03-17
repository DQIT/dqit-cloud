package top.dqit.cloud.security.util;

import top.dqit.cloud.security.bcrypt.BCryptPasswordEncoder;

/**
 * 密码工具类
 * @author mr_hqing@163.com
 * @since 2022/3/16
 */
public class PasswordUtil {
	public static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	
	/**
	 * 密码加密
	 * @param password 密码(明文)
	 * @return 密文
	 */
	public static String encode(String password){
		return bCryptPasswordEncoder.encode(password);
	}
	
	/**
	 * 密码验证
	 * @param password 密码(明文)
	 * @param encodedPassword 密码(密文)
	 * @return 是否匹配
	 */
	public static boolean verify(String password, String encodedPassword){
		return bCryptPasswordEncoder.matches(password, encodedPassword);
	}
}
