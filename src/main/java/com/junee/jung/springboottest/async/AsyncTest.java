package com.junee.jung.springboottest.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AsyncTest {


    @Async
    public void getSum(int startIndex , int size){
        log.info("Current Thread Name {}",Thread.currentThread().getName());
        var sum = 0L;
        for(int i = startIndex ; i< startIndex+size ; i++){
            sum += i;
        }
        log.info("sum {}",sum);
    }

}
