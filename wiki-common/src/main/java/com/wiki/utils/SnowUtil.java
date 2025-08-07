package com.wiki.utils;

import cn.hutool.core.util.IdUtil;

/**
 * @BelongsProject: wiki
 * @BelongsPackage: com.wiki.utils
 * @Author: zhuningkang
 * @CreateTime: 2025-08-07  22:00:30
 * @Description: 封装hutool的雪花算法
 * @Version: 1.0
 */
public class SnowUtil {

    private SnowUtil() {
        // 私有化构造函数，防止实例化
    }

    /**
     * 数据中心ID
     */
    private static long dataCenterId = 1;

    /**
     * 工作节点ID
     */
    private static long workerId = 1;

    public static long getSnowflakeNextId() {
        return IdUtil.getSnowflake(dataCenterId, workerId).nextId();
    }

    public static String getSnowflakeNextIdStr() {
        return IdUtil.getSnowflake(dataCenterId, workerId).nextIdStr();
    }
}
