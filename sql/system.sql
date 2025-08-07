DROP TABLE IF EXISTS sys_user;
CREATE TABLE sys_user
(
    `id`            BIGINT       NOT NULL COMMENT 'ID',
    `nick_name`     VARCHAR(50) COMMENT '昵称',
    `user_name`     VARCHAR(50)  NOT NULL COMMENT '用户名称',
    `password`      VARCHAR(200) NOT NULL COMMENT '密码',
    `mobile`        INT COMMENT '手机号',
    `email`         VARCHAR(100) COMMENT '邮箱',
    `avatar_url`    VARCHAR(100) COMMENT '头像',
    `gender`        TINYINT(1)   COMMENT '性别(0-女,1-男,2-其他)',
    `status`        TINYINT(1) NOT NULL DEFAULT 0 COMMENT '状态(0-正常,1-禁用)',
    `login_count`   INT COMMENT '登录次数',
    `login_time`    DATETIME COMMENT '登录时间',
    `login_address` VARCHAR(50) COMMENT '登录地址',
    `role_id`       BIGINT       NOT NULL COMMENT '权限ID',
    `create_time`   DATETIME     NOT NULL COMMENT '新增时间',
    `update_time`   DATETIME     NOT NULL COMMENT '更新时间',
    `is_deleted`    TINYINT(1) NOT NULL  COMMENT '是否删除',
    `tenant_id`     BIGINT COMMENT '租户ID',
    `create_by_id`  BIGINT(32) NOT NULL  COMMENT '新增用户ID',
    `create_by`     VARCHAR(50)  NOT NULL COMMENT '新增用户名称',
    `update_by_id`  BIGINT       NOT NULL COMMENT '更新用户ID',
    `update_by`     VARCHAR(50)  NOT NULL COMMENT '更新用户名称',
    `version`       BIGINT COMMENT '乐观锁',
    PRIMARY KEY (id)
) COMMENT = '用户表;';
