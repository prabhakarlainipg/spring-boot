package com.example.learning.service;


import com.example.learning.config.AppProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WelcomeService {

    private final String welcomeMessage;

    //If the property is missing, Spring uses "HELLO WORLD".
  /*  public WelcomeService(@Value("${app.welcome-message2:HELLO WORLD}") String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }*/

    public WelcomeService(AppProperties properties) {
        this.welcomeMessage = properties.welcomeMessage();
    }


    public String welcome() {
        return welcomeMessage;
    }
}
