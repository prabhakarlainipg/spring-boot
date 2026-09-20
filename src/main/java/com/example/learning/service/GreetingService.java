package com.example.learning.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public GreetingService() {
        System.out.println("1.Greeting Service is created");
    }

    public String greet(String name) {

        return "Hello, " +name + "! Welcome to Spring.";
    }
}
