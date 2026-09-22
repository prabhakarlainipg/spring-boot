package com.example.learning.exception;

public class UserNotFoundException  extends  Exception{
    public UserNotFoundException(Long userId) {
        super("User not found with ID: "+userId);
    }
}
