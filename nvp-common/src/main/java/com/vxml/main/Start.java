package com.vxml.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by litong on 2017/11/28.
 */
@SpringBootApplication
@ComponentScan("com")
public class Start extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication ap = new SpringApplication(Start.class);
        ap.run(args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Start.class);
    }
}
