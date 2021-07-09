package com.springboot.donutqueue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "com.springboot.donutqueue" })
public class DonutqueueApplication {

	public static void main(String[] args) {
		SpringApplication.run(DonutqueueApplication.class, args);
	}

}
