package com.wiki.system.user.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
* @BelongsProject: wiki
* @BelongsPackage: com.wiki.system.user.dto
* @Author zhuningkang
* @CreateTime 2025-08-07 20:36:34
* @Description: sys_user 删除 DTO 类
* @version 1.0
*/
@Data
public class UserDeletedDto {

    /**
    * 身份标识
    */
    @NotNull(message = "身份标识不能为空")
    private Long Id;
}
