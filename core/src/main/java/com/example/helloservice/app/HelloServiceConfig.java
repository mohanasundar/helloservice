package com.example.helloservice.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.helloservice.decorators.CapitalizeMessageDecorator;
import com.example.helloservice.decorators.MessageDecorator;


@Configuration
public class HelloServiceConfig {

    @Bean
    MessageDecorator messageDecorator() {

        return new CapitalizeMessageDecorator();
    }
}