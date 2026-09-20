package com.example.learning.controller;


import com.example.learning.service.GreetingService;
import com.example.learning.service.MessageService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

   // private final GreetingService greetingService;

    private final MessageService messageService;


    public HelloController( @Qualifier("hindi") MessageService messageService) {
        this.messageService = messageService;
       // System.out.println("2. HelloController created");
    }

    @GetMapping("/hello")
    public String hello(
            @RequestParam(defaultValue = "Developer") String name) {

        System.out.println("3. Request received for: " + name);

        return messageService.greet(name);
    }
}