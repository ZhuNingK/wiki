package com.wiki.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @BelongsProject: wiki
 * @BelongsPackage: com.wiki.config
 * @Author: zhuningkang
 * @CreateTime: 2025-08-07  10:36:54
 * @Description: 异步任务配置类
 * @Version: 1.0
 */
@Configuration
@Slf4j
public class AsyncTaskConfig {

    @Bean
    public AsyncTaskExecutor asyncTask() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 设置核心线程数
        executor.setCorePoolSize(10);
        // 设置最大线程数
        executor.setMaxPoolSize(20);
        // 设置队列容量
        executor.setQueueCapacity(30);
        // 设置线程名称前缀
        executor.setThreadNamePrefix("asyncExecutor-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        executor.initialize();
        return executor;

    }
}
