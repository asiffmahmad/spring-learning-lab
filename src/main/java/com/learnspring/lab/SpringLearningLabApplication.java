package com.learnspring.lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;


@EnableJms
@SpringBootApplication
public class SpringLearningLabApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringLearningLabApplication.class, args);
	}

	
}
