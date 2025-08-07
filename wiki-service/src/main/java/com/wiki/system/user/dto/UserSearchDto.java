package com.wiki.system.user.dto;

import com.wiki.core.page.PageRequest;
import lombok.Data;

/**
* @BelongsProject: wiki
* @BelongsPackage: com.wiki.system.user.dto
* @Author zhuningkang
* @CreateTime 2025-08-07 20:36:34
* @Description: sys_user 搜索 DTO 类
* @version 1.0
*/
@Data
public class UserSearchDto extends PageRequest {

    /**
    * 搜索词
    */
    private String word;
}