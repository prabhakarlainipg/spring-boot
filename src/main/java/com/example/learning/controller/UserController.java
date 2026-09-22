package com.example.learning.controller;

import com.example.learning.exception.UserNotFoundException;
import com.example.learning.model.CreateUserRequest;
import com.example.learning.model.UserResponse;
import com.example.learning.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(
            @Valid @RequestBody CreateUserRequest request) {

        UserResponse createdUser = userService.createUser(request);

        URI location = URI.create("/users/" + createdUser.id());

        return ResponseEntity.created(location).body(createdUser);
    }

    @GetMapping("/{userId}")
    public UserResponse getUser(@PathVariable Long userId) throws UserNotFoundException {
        return userService.getUser(userId);
    }

    @GetMapping(params = "userName")
    public UserResponse getUserByName(@RequestParam("userName") String userName) throws UserNotFoundException {
        return userService.getUserByName(userName);
    }

    @GetMapping(params = "!userName")
    public Page<UserResponse> getUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        return userService.getUsers(page, size);
    }


    @PostMapping("/rollback-demo")
    public void demonstrateRollback(
            @Valid @RequestBody CreateUserRequest request) {

        userService.demonstrateRollback(request);
    }


}
