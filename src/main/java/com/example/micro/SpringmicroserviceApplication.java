package com.example.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringmicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringmicroserviceApplication.class, args);
	}

}
