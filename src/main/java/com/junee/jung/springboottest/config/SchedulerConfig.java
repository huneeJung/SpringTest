package com.junee.jung.springboottest.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.lang.management.ManagementFactory;
import java.util.HashMap;
import java.util.Map;

@Configuration
@Slf4j
public class SchedulerConfig implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        int n = Runtime.getRuntime().availableProcessors();
        log.info("사용 가능한 쓰레드 개수 ::: {}", n);
        log.info("사용 가능한 쓰레드 개수 ::: {}" ,ManagementFactory.getThreadMXBean().getThreadCount());
        scheduler.setPoolSize(n);
        scheduler.setThreadNamePrefix("scheduled-task-");
        scheduler.setAwaitTerminationSeconds(30);
        scheduler.setWaitForTasksToCompleteOnShutdown(true);
        scheduler.initialize();
        taskRegistrar.setTaskScheduler(scheduler);
    }
}
