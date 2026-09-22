package com.example.learning.controller;

import com.example.learning.exception.UserNotFoundException;
import com.example.learning.model.CreateUserRequest;
import com.example.learning.model.UserResponse;
import com.example.learning.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

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
    public UserResponse getUser(@PathVariable Long userId) throws UserNotFoundException {
        return userService.getUser(userId);
    }


}
