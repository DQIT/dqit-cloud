package top.dqit.cloud.system.user.model;

import top.dqit.common.constants.DateTimeFormatterPattern;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;

/**
 * todo LocalDate类型的example不显示问题
 * @author mr_hqing@163.com
 * @since 2022/3/12
 */
@Schema(description = "UserInfo")
@Data
public class UserInfo {
	@Schema(description = "姓名", example = "张三", maxLength = 20, minLength = 2)
	private String name;
	
	@Schema(description = "出生日期", example = "2022-01-01", accessMode = Schema.AccessMode.READ_ONLY, type = "String")
	@JsonFormat(pattern = DateTimeFormatterPattern.HORIZONTAL_LINE_DATE_PATTERN)
	private LocalDate bornDate;
	
	@Schema(description = "性别", example = "true", accessMode = Schema.AccessMode.READ_ONLY)
	private Boolean gender;
}
