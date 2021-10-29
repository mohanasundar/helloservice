package com.example.helloservice.model;

import java.util.Date;


public class Greeting {

    private String message;

    private Date responseTime;

    public String getMessage() {

        return message;
    }

    public Date getResponseTime() {

        return responseTime;
    }

    public Greeting(String message, Date responseTime) {

        super();
        this.message = message;
        this.responseTime = responseTime;
    }
}