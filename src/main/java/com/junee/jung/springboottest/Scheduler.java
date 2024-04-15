package com.junee.jung.springboottest;

import com.junee.jung.springboottest.async.AsyncTest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class Scheduler {

    private final AsyncTest asyncTest;

    @Scheduled(initialDelay = 10,fixedDelay = 200000)
    public void start(){
        var size = 1000000000;
        var startIndex = 0;
        while(size > 0){
            var chunk = size/100;
            asyncTest.getSum(startIndex,size);
            startIndex+= chunk;
            size-=chunk;
        }
    }

}
