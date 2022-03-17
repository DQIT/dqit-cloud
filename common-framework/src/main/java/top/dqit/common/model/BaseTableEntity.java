package top.dqit.common.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * 持久层基础实体类
 * @author mr_hqing@163.com
 * @since 2022/3/12
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@MappedSuperclass
public class BaseTableEntity {
	
	/**
	 * 创建时间
	 */
	@Column(name = "create_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createTime = getCreateTime();
	
	/**
	 * 是否已删除
	 */
	@Column(name = "is_deleted", updatable = false)
	private Boolean isDeleted = false;
}
