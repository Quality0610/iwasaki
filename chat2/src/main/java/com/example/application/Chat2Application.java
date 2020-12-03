package com.example.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.example")
@SpringBootApplication
public class Chat2Application {

	public static void main(String[] args) {
		SpringApplication.run(Chat2Application.class, args);
	}

}
