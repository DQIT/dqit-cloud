package top.dqit.common.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

/**
 * 持久层基础实体类
 * @author mr_hqing@163.com
 * @since 2022/3/12
 */
@Data
public class BaseTableEntity {
	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.ASSIGN_ID)
	private String id;
	
	/**
	 * 创建时间
	 */
	@TableField(value = "create_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createTime = getCreateTime();
	
	/**
	 * 是否已删除
	 */
	@TableField(value = "is_deleted")
	@TableLogic(value = "false", delval = "true")
	private Boolean isDeleted = false;
}
