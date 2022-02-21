package com.mx.aplazo.simpleinterest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.mx.aplazo.simpleinterest.model")
public class SimpleInterestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleInterestApplication.class, args);
	}

}
