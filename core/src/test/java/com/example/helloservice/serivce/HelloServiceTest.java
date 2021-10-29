package com.example.helloservice.serivce;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.example.helloservice.decorators.MessageDecorator;
import com.example.helloservice.model.Greeting;


public class HelloServiceTest {

    @InjectMocks
    private HelloService helloService;

    @Mock
    private MessageDecorator messageDecorator;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetGreeting() {

        when(messageDecorator.decorate(anyString())).thenReturn("Peter");

        Greeting greeting = helloService.getGreeting("peter");
        assertNotNull(greeting.getResponseTime());
        assertEquals("Hello Peter", greeting.getMessage());

        Mockito.verify(messageDecorator, times(1)).decorate(Mockito.anyString());
    }

    @Test
    public void testGetGreetingWithBlank() {

        Greeting greeting = new HelloService().getGreeting("");
        assertNotNull(greeting.getResponseTime());
        assertEquals("Hello World", greeting.getMessage());
    }

    @Test
    public void testGetGreetingWithNull() {

        Greeting greeting = new HelloService().getGreeting(null);
        assertNotNull(greeting.getResponseTime());
        assertEquals("Hello", greeting.getMessage());
    }

}
