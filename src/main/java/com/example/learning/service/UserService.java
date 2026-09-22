package com.example.learning.service;


import com.example.learning.exception.UserNotFoundException;
import com.example.learning.model.UserResponse;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public UserResponse getUser(Long id) throws UserNotFoundException {

        if (!Long.valueOf(42).equals(id)) {
            throw new UserNotFoundException(id);
        }

        return new UserResponse(
                42L,
                "Prabhakar",
                "prabhakar@example.com"
        );

    }
}

