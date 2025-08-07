package com.wiki.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;

/**
 * MybatisPlus 自动填充处理器
 * 用于在插入和更新操作时自动填充实体的时间和用户相关字段
 *
 * @BelongsProject: wiki
 * @BelongsPackage: com.wiki.handler
 * @Author: zhuningkang
 * @CreateTime: 2025-08-07  10:43:23
 * @Description: 配置mybatis-plus处理器
 * @Version: 1.0
 */
public class MybatisPlusMetaObjectHandler implements MetaObjectHandler {

    // 是否启用登录用户相关字段自动填充
    @Value("${mybatis-plus.login:false}")
    private Boolean login;

    /**
     * 插入数据时自动填充字段
     *
     * @param metaObject 元对象
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        // 填充创建时间和更新时间
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());

        // 如果启用登录用户相关字段，填充创建/更新人信息
        if (Boolean.TRUE.equals(login)) {
            this.strictInsertFill(metaObject, "createById", LocalDateTime.class, LocalDateTime.now());
            this.strictInsertFill(metaObject, "createBy", LocalDateTime.class, LocalDateTime.now());
            this.strictInsertFill(metaObject, "updateById", LocalDateTime.class, LocalDateTime.now());
            this.strictInsertFill(metaObject, "updateBy", LocalDateTime.class, LocalDateTime.now());
        }
    }

    /**
     * 更新数据时自动填充字段
     *
     * @param metaObject 元对象
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        // 填充更新时间
        this.strictInsertFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
        // 如果启用登录用户相关字段，填充更新人信息
        if (Boolean.TRUE.equals(login)) {
            this.strictInsertFill(metaObject, "updateById", LocalDateTime.class, LocalDateTime.now());
            this.strictInsertFill(metaObject, "updateBy", LocalDateTime.class, LocalDateTime.now());
        }
    }
}