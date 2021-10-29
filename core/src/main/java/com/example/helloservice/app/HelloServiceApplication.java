package com.example.helloservice.app;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.example.helloservice")
public class HelloServiceApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {

        new SpringApplicationBuilder(HelloServiceApplication.class).run(args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

        return application.sources(HelloServiceApplication.class);
    }

}
