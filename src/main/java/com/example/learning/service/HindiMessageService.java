package com.example.learning.service;

import org.springframework.stereotype.Service;

//default hindiMessageService is the bean name springUses as per ClassName, we can customize it as below.
@Service("hindi")
public class HindiMessageService implements MessageService{
    @Override
    public String greet(String name) {
        return "Namaste, " + name;
    }
}
