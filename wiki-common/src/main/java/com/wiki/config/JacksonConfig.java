package com.wiki.config;

import cn.hutool.core.date.DatePattern;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @BelongsProject: wiki
 * @BelongsPackage: com.wiki.config
 * @Author: zhuningkang
 * @CreateTime: 2025-08-06  16:59:13
 * @Description: Jackson配置类
 * @Version: 1.0
 */
@Configuration
@Slf4j
public class JacksonConfig {

    /**
     * 配置 Jackson 的自定义序列化和反序列化规则。
     * <ul>
     *   <li>设置本地化为中国</li>
     *   <li>设置时区为系统默认</li>
     *   <li>设置日期时间格式为 yyyy-MM-dd HH:mm:ss</li>
     *   <li>Long 类型序列化为字符串，防止精度丢失</li>
     *   <li>LocalDateTime 使用自定义格式序列化和反序列化</li>
     * </ul>
     *
     * @return Jackson2ObjectMapperBuilderCustomizer 实例
     */
    @Bean
    @ConditionalOnMissingBean
    public Jackson2ObjectMapperBuilderCustomizer customizer() {
        log.info("[Jackson2ObjectMapperBuilderCustomizer][init:customizer config]");
        return builder -> {
            builder.locale(Locale.CHINA);
            builder.timeZone(TimeZone.getTimeZone(ZoneId.systemDefault()));
            builder.simpleDateFormat(DatePattern.NORM_DATETIME_PATTERN);
            builder.serializerByType(Long.class, ToStringSerializer.instance);
            builder.serializerByType(LocalDateTime.class, new LocalDateTimeSerializer(DatePattern.NORM_DATETIME_FORMATTER));
            builder.deserializerByType(LocalDateTime.class, new LocalDateTimeDeserializer(DatePattern.NORM_DATETIME_FORMATTER));
        };
    }
}
