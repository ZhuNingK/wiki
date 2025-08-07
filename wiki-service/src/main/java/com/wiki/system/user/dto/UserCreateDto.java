package com.wiki.system.user.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wiki.core.entity.BaseEntity;
import java.time.LocalDateTime;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


/**
* @BelongsProject: wiki
* @BelongsPackage: com.wiki.system.user.dto
* @Author zhuningkang
* @CreateTime 2025-08-07 20:36:34
* @Description: sys_user Create DTO 类
* @version 1.0
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateDto {


    /**
    * 昵称
    */
    private String nickName;

    /**
    * 用户名称
    */
    private String userName;

    /**
    * 密码
    */
    private String password;

    /**
    * 手机号
    */
    private String mobile;

    /**
    * 邮箱
    */
    private String email;

    /**
    * 头像
    */
    private String avatarUrl;

    /**
    * 性别(0-女,1-男,2-其他)
    */
    private Boolean gender;

    /**
    * 状态(0-正常,1-禁用)
    */
    private Boolean status;

    /**
    * 登录次数
    */
    private Integer loginCount;

    /**
    * 登录时间
    */
    private LocalDateTime loginTime;

    /**
    * 登录地址
    */
    private String loginAddress;

    /**
    * 权限ID
    */
    private Long roleId;




}