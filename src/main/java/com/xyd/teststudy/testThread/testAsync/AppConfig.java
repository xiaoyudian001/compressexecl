package com.xyd.teststudy.testThread.testAsync;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
@ComponentScan("com.xyd.teststudy.testThread.testAsync")
// 指定要扫描的包路径
public class AppConfig implements AsyncConfigurer {
    @Override
    @Bean
    public TaskExecutor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 设置核心线程池大小
        executor.setCorePoolSize(10);
        // 设置最大线程池大小
        executor.setMaxPoolSize(100);
        // 设置队列容量
        executor.setQueueCapacity(10);
        executor.initialize();
        return executor;
    }
}
