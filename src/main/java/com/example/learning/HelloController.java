package com.example.learning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//@Controller+@ResponseBody
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(@RequestParam(defaultValue = "Prabhakar") String name){
        return "Hello! " +name+", Welcome to Spring Boot";
    }
}
