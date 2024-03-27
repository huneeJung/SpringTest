package com.junee.jung.springboottest;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
@EnableScheduling
@SpringBootApplication
public class SpringBootTestApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootTestApplication.class, args);
	}
}
