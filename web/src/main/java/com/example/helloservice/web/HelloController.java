package com.example.helloservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.helloservice.model.Greeting;
import com.example.helloservice.serivce.HelloService;


@RestController
public class HelloController {

    @Autowired
    private HelloService service;

    @RequestMapping(value = "greeting/hello", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Greeting getDefaultGreeting() {

        return this.service.getGreeting("");
    }

    @RequestMapping(value = "greeting/hello/{subject}", method = RequestMethod.GET, produces = { "application/json" })
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Greeting getGreeting(@PathVariable("subject") String subject) throws Exception {

        return this.service.getGreeting(subject);
    }
}
