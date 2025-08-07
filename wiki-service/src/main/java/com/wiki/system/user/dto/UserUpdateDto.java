package com.wiki.system.user.dto;

import lombok.Data;

/**
* @BelongsProject: wiki
* @BelongsPackage: com.wiki.system.user.dto
* @Author zhuningkang
* @CreateTime 2025-08-07 20:36:34
* @Description: sys_user 更新 DTO 类
* @version 1.0
*/
@Data
public class UserUpdateDto extends UserCreateDto{

    /**
    * id值
    */
    private Long Id;
}
