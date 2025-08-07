package com.wiki.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.core.env.Environment;

/**
 * @BelongsProject: wiki
 * @BelongsPackage: com.wiki.config
 * @Author: zhuningkang
 * @CreateTime: 2025-08-07  10:57:08
 * @Description: WikiApplication 项目启动类
 * @Version: 1.0
 */
@SpringBootApplication(
        // 排除数据源自动配置，避免与其他配置冲突
        exclude = {DataSourceAutoConfiguration.class},
        scanBasePackages = "com.wiki")
public class WikiApplication {

    private static final Logger LOG = LoggerFactory.getLogger(WikiApplication.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(WikiApplication.class);
        Environment env = app.run(args).getEnvironment();
        LOG.info("启动成功！！");
        LOG.info("地址: \thttp://127.0.0.1:{}", env.getProperty("server.port"));
    }
}
