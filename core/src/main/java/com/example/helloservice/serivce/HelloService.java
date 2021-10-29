package com.example.helloservice.serivce;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.helloservice.decorators.MessageDecorator;
import com.example.helloservice.model.Greeting;


@Service
public class HelloService {

    @Autowired
    private MessageDecorator messageDecorator;

    private static final String GREETING_PREFIX = "Hello";

    public Greeting getGreeting(String input) {

        String greetingMessage = "";
        for (int i = 0; i < 1; i++) {
            if (!StringUtils.isEmpty(input)) {
                greetingMessage = " " + messageDecorator.decorate(input);
            } else if (input != null) {
                greetingMessage = " World";
            }
        }

        return new Greeting(GREETING_PREFIX + greetingMessage, new Date());
    }
}
