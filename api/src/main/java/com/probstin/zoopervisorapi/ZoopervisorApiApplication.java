package com.probstin.zoopervisorapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ZoopervisorApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZoopervisorApiApplication.class, args);
	}

}
