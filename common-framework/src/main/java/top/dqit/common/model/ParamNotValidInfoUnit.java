package top.dqit.common.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

/**
 * 参数校验不通过字段信息单元
 * @author mr_hqing@163.com
 * @since 2022/3/16
 */
@Data
@Builder
public class ParamNotValidInfoUnit {
	@Schema(description = "字段名", example = "name", accessMode = Schema.AccessMode.READ_ONLY)
	private String fieldName;
	
	@Schema(description = "错误信息", example = "名称不能为空", accessMode = Schema.AccessMode.READ_ONLY)
	private String message;
}
