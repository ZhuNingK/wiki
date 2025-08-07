<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${package.Mapper}.${table.mapperName}">

    <#if enableCache?? && enableCache>
        <!-- 开启二级缓存 -->
        <cache type="${cacheClassName}"/>
    </#if>

    <#if baseResultMap?? && baseResultMap>
        <!-- 通用查询映射结果 -->
        <resultMap id="BaseResultMap" type="${package.Entity}.${entity}">
            <#-- 主键 -->
            <#list table.fields as field>
                <#if field.keyFlag>
                    <id column="${field.name}" property="${field.propertyName}" />
                </#if>
            </#list>

            <#-- 公共字段 -->
            <#list table.commonFields as field>
                <result column="${field.name}" property="${field.propertyName}" />
            </#list>

            <#-- 普通字段 -->
            <#list table.fields as field>
                <#if !field.keyFlag>
                    <result column="${field.name}" property="${field.propertyName}" />
                </#if>
            </#list>
        </resultMap>
    </#if>

    <#if baseColumnList?? && baseColumnList>
        <!-- 通用查询结果列 -->
        <sql id="Base_Column_List">
            <#list table.commonFields as field>
                ${field.columnName},
            </#list>
            ${table.fieldNames}
        </sql>
    </#if>

</mapper>