package com.example.learning.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

//@Service
public class GreetingService {

    public GreetingService() {
        System.out.println("1.Greeting Service is created");
    }
    @PostConstruct
    public void initialize() {
        System.out.println("2. PostConstruct: bean initialized");
    }

    public String greet(String name) {

        return "Hello, " +name + "! Welcome to Spring.";
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("3. PreDestroy: bean being destroyed");
    }
}
