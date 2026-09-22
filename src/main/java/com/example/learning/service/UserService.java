package com.example.learning.service;


import com.example.learning.exception.UserNotFoundException;
import com.example.learning.model.CreateUserRequest;
import com.example.learning.model.User;
import com.example.learning.model.UserResponse;
import com.example.learning.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse getUser(Long id) throws UserNotFoundException {

        User savedUser = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException(id));
        return new UserResponse(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail()
        );
    }


    public UserResponse getUserByName(String name) throws UserNotFoundException {

        List<User> users = userRepository.findByName(name);
        //getFirst() ->
       // Requirements:If this List is not empty,
        // the implementation in this interface returns the result of calling get(0).
        // Otherwise, it throws NoSuchElementException.
        return new UserResponse(
                users.getFirst().getId(),
                users.getFirst().getName(),
                users.getFirst().getEmail()
        );
    }

    @Transactional
    public UserResponse createUser(CreateUserRequest request) {
        User user = new User(request.name(), request.email());
        User savedUser = userRepository.save(user);
        return new UserResponse(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail()
        );


    }
}

