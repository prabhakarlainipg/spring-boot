package com.example.learning.config;

import com.example.learning.service.GreetingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


//Spring documents that a @Bean method replaces the scanned
// definition when the bean name and return type match, as yours do

@Configuration
public class AppConfig {

    //@Bean tells Spring to register the object returned by this method as a MANAGED BEAN.
    //default scope is singleton .. @Scope("prototype")
    @Bean
    //@Scope("prototype")
    public GreetingService greetingService(){
        System.out.println("Creating GreetingService through AppConfig");
        return new GreetingService();
    }

    //CommandLineRunner - lets us run this check during application startup
    @Bean
    public CommandLineRunner inspectBeans(ApplicationContext context) {
        return args -> {
            GreetingService first =
                    context.getBean(GreetingService.class);
//With prototype scope, each getBean() call requests a new instance.
            GreetingService second =
                    context.getBean(GreetingService.class);

            System.out.println("Same object? " + (first == second));
        };
    }
}
