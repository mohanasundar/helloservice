package com.example.helloservice.web;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import io.restassured.RestAssured;


public class HelloControllerIT {

    @Test
    public void testGetMessage() {

        String response = RestAssured.given().get("http://localhost:8080/greeting/hello/Joshua").then().statusCode(200)
            .and().body("responseTime", is(notNullValue())).body("message", is("Hello Joshua")).extract().asString();

        assertNotNull(response);
    }

}