package com.junee.jung.springboottest.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class SchedulerTest {

    @Async
//    @Scheduled(initialDelay = 1000,fixedRate = 1000)
    public void testTask() throws InterruptedException {
        log.info("스케줄러 종료 ::: endTime {} ",LocalDateTime.now() + "");
        var sum = 0;
        for(int i = 0 ; i < 100000000 ; i++){
            sum += i;
        }
        log.info("합계 ::: {}",sum);
        log.info("스케줄러 시작 ::: startTime {}",LocalDateTime.now());

        Thread.sleep(12000);


    }

}
