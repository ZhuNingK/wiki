package com.wiki.core.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 基础实体类，包含通用字段和逻辑删除标记
 * <p>
 * 该类用于所有实体类的基类，提供了通用的字段如创建时间、更新时间、创建人、更新人等。
 * 还包含逻辑删除字段和租户ID字段，适用于多租户场景。
 * </p>
 *
 * @author zhuningkang
 * @BelongsProject: wiki
 * @BelongsPackage: com.wiki.core.entity
 */
@Setter
@Getter
public class BaseEntity implements Serializable {

    private Long id;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    private Long createById;

    private String createBy;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    private Long updateById;

    private String updateBy;

    @TableField(fill = FieldFill.INSERT)
    @TableLogic
    private Boolean isDeleted;

    private Long tenantId;

    private int version;
}
