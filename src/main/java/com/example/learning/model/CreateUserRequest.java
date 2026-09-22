package com.example.learning.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateUserRequest(
        @NotBlank(message = "Name is Required")
        String name,

        @NotBlank(message = "Email is Required")
        @Email(message = "Email must be valid")
        String email) {
}
