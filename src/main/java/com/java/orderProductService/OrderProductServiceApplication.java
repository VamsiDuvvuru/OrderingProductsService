package com.java.orderProductService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class OrderProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderProductServiceApplication.class, args);
	}

}
