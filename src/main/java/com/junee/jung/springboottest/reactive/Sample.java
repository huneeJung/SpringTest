package com.junee.jung.springboottest.reactive;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Sample {
    public static void main(String[] args) throws InterruptedException {
        Flux.just(100, 200, 300, 400, 500)
                .subscribeOn(Schedulers.boundedElastic()) // 구독을 처리할 스케줄러
                .doOnNext(data -> System.out.println(getThreadName() + " : " + "#doOnNext() : " + data)) // 데이터가 스트림을 통과할 때 현재 스레드를 출력
                .publishOn(Schedulers.parallel()) // 모든 데이터 처리 연산은 parallel 스케줄러에서 실행
                .filter(number -> number > 300)
                .subscribe(num -> System.out.println(getThreadName() + " : result : " + num));

        // 메인 스레드가 종료되지 않도록 대기
        Thread.sleep(500);
    }

    public static String getThreadName() {
        return Thread.currentThread().getName();
    }
}
