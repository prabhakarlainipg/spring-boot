package com.example.learning.controller;

import com.example.learning.model.CreateUserRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping ("/{userId}")
    public String createUser(@PathVariable String userId, @RequestParam String city,  @RequestBody CreateUserRequest request){
        return "User: " + userId
                + ", City: " + city
                + ", name: " + request.name()
                + ", email: " + request.email();
    }


}
