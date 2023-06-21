package com.example.ProjectY;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class BaseSpringApplication {
// MAIN CLASS
	public static void main(String[] args) {
		SpringApplication.run(BaseSpringApplication.class, args);
	}

}
