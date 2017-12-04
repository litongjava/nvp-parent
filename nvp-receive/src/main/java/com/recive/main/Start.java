package com.recive.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com")
public class Start extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Start.class);
	}
	public static void main(String[] args){
		//启动方式1
		//SpringApplication.run(Start.class, args);
		//启动方式2
		SpringApplication ap = new SpringApplication(Start.class);
		ap.run(args);
	}
}
