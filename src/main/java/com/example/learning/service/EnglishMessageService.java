package com.example.learning.service;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class EnglishMessageService implements MessageService{
    @Override
    public String greet(String name) {
        return "Hello, " + name;
    }
}
