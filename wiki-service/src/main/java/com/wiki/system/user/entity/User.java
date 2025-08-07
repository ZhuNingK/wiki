package com.wiki.system.user.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wiki.core.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @version 1.0
 * @BelongsProject: wiki
 * @BelongsPackage: com.wiki.system.user.entity
 * @Author zhuningkang
 * @CreateTime 2025-08-07 20:36:34
 * @Description: sys_user 实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("sys_user")
public class User extends BaseEntity {

    /**
     * 昵称
     */
    @TableField("nick_name")
    private String nickName;
    /**
     * 用户名称
     */
    @TableField("user_name")
    private String userName;
    /**
     * 密码
     */
    @TableField("password")
    private String password;
    /**
     * 手机号
     */
    @TableField("mobile")
    private String mobile;
    /**
     * 邮箱
     */
    @TableField("email")
    private String email;
    /**
     * 头像
     */
    @TableField("avatar_url")
    private String avatarUrl;
    /**
     * 性别(0-女,1-男,2-其他)
     */
    @TableField("gender")
    private Boolean gender;
    /**
     * 状态(0-正常,1-禁用)
     */
    @TableField("status")
    private Boolean status;
    /**
     * 登录次数
     */
    @TableField("login_count")
    private Integer loginCount;
    /**
     * 登录时间
     */
    @TableField("login_time")
    private LocalDateTime loginTime;
    /**
     * 登录地址
     */
    @TableField("login_address")
    private String loginAddress;
    /**
     * 权限ID
     */
    @TableField("role_id")
    private Long roleId;


}