package com.example.learning.config;

import com.example.learning.service.GreetingService;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class GreetingAutoConfiguration {
    @Bean


    //The auto-configuration therefore backs off,
    // letting your bean supply the service.
    // This is conditional registration: Spring avoids registering the default in the first place.


    @ConditionalOnMissingBean(GreetingService.class)
    public GreetingService greetingService() {
        return new GreetingService();
    }
}
