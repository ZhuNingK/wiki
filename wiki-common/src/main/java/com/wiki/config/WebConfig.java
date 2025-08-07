package com.wiki.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @BelongsProject: wiki
 * @BelongsPackage: com.wiki.config
 * @Author: zhuningkang
 * @CreateTime: 2025-08-07  10:38:19
 * @Description: Web配置类
 * @Version: 1.0
 */
@Configuration
@Slf4j
public class WebConfig {

    /**
     * 跨域配置
     */
    @Bean
    public CorsFilter corsFilter() {
        log.info("[CorsFilter][init: corsFilter config]");
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        // 设置访问源地址
        config.addAllowedOriginPattern("*");
        // 设置访问源请求头
        config.addAllowedHeader("*");
        // 设置访问源请求方法
        config.addAllowedMethod("*");
        // 有效期 1800秒
        config.setMaxAge(1800L);
        // 添加映射路径，拦截一切请求
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        // 返回新的CorsFilter
        return new CorsFilter(source);
    }
}
