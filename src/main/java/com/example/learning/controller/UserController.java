package com.example.learning.controller;

import com.example.learning.exception.UserNotFoundException;
import com.example.learning.model.CreateUserRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping ("/{userId}")
    public String createUser(@PathVariable String userId,
                             @RequestParam String city,
                             @Valid
                             @RequestBody CreateUserRequest request){
        return "User: " + userId
                + ", City: " + city
                + ", name: " + request.name()
                + ", email: " + request.email();
    }

    @GetMapping("/{userId}")
    public String getUser(@PathVariable Long userId) throws UserNotFoundException {
        if(!Long.valueOf(42).equals(userId)){
            throw new UserNotFoundException(userId);
        }
        return "User: Prabhakar";
    }


}
