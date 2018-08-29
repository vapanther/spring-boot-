package com.crosscode.local1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
@SpringBootApplication
public class LocalhostDbAppApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(LocalhostDbAppApplication.class, args);
	}
}
