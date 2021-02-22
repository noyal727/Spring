package com.example.Spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		System.out.println("Hello WORLD");
		SpringApplication.run(Application.class, args);
	}

}
