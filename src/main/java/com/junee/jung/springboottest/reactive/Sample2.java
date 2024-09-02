package com.junee.jung.springboottest.reactive;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class Sample2 {

        @GetMapping(path = "/stock-prices", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
        public Flux<Double> getStockPrices() {
            return Flux.interval(Duration.ofSeconds(1))
                    .map(this::fetchLatestPrice); // 주식 시세를 주기적으로 가져옴
        }

        private Double fetchLatestPrice(Long interval) {
            // 실제 주식 시세를 외부 서비스나 데이터베이스에서 가져오는 로직
            return Math.random() * 1000; // 예제 용도로 랜덤 시세 생성
        }
}
