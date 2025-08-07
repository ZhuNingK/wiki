package com.wiki.utils;

import com.baomidou.mybatisplus.generator.config.DataSourceConfig;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @BelongsProject: springboot-mybatis-plus
 * @BelongsPackage: cn.chinacici.utils
 * @Author: zhuningkang
 * @CreateTime: 2025-07-31  16:07:40
 * @Description: 数据库工具类
 * @Version: 1.0
 */
public class DbUtil {

    /**
     * 获取数据库连接信息
     *
     * @param dbHost 数据库主机
     * @param dbPort 数据库端口
     * @param dbName 数据库名称
     * @param dbUser 数据库用户名
     * @param dbPass 数据库密码
     * @return 数据源配置
     */
    public static DataSourceConfig.Builder getDataSourceConfig(String dbHost, Integer dbPort, String dbName, String dbUser, String dbPass) {
        String url = String.format(
                "jdbc:mysql://%s:%d/%s?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false",
                dbHost, dbPort, dbName
        );
        return new DataSourceConfig
                .Builder(url, dbUser, dbPass)
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .schema(dbName);
    }

    /**
     * 下划线转小驼峰：member_id 转成 memberId
     */
    public static String lineToHump(String str) {
        Pattern linePattern = Pattern.compile("_(\\w)");
        str = str.toLowerCase();
        Matcher matcher = linePattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * 下划线转大驼峰：member_id 转成 MemberId
     */
    public static String lineToBigHump(String str) {
        String s = lineToHump(str);
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

    /**
     * 数据库类型转为Java类型
     *
     * @param sqlType SQL数据类型
     * @return 对应的Java类型
     */
    public static String sqlTypeToJavaType(String sqlType) {
        if (sqlType.toUpperCase().contains("varchar".toUpperCase())
                || sqlType.toUpperCase().contains("char".toUpperCase())
                || sqlType.toUpperCase().contains("text".toUpperCase())) {
            return "String";
        } else if (sqlType.toUpperCase().contains("datetime".toUpperCase())) {
            return "LocalDateTime";
        } else if (sqlType.toUpperCase().contains("time".toUpperCase())) {
            return "LocalDateTime";
        } else if (sqlType.toUpperCase().contains("date".toUpperCase())) {
            return "Date";
        } else if (sqlType.toUpperCase().contains("bigint".toUpperCase())) {
            return "Long";
        } else if (sqlType.toUpperCase().contains("int".toUpperCase())) {
            return "Integer";
        } else if (sqlType.toUpperCase().contains("long".toUpperCase())) {
            return "Long";
        } else if (sqlType.toUpperCase().contains("decimal".toUpperCase())) {
            return "BigDecimal";
        } else if (sqlType.toUpperCase().contains("boolean".toUpperCase())) {
            return "Boolean";
        } else {
            return "String";
        }
    }
}
