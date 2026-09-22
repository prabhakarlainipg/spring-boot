package com.example.learning.service;

import com.example.learning.exception.UserNotFoundException;
import com.example.learning.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.when;

//Enables Mockito support for the test
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    //Creates a mock repository
    @Mock
    private UserRepository userRepository;

    //Creates the service and injects its mock dependencies
    @InjectMocks
    private UserService userService;

    //Marks a test method
    @Test
    void getUser_whenUserDoesNotExist_throwsUserNotFoundException() {
        // Arrange: configure the repository's response
        when(userRepository.findById(99L))
                .thenReturn(Optional.empty());

        // Act and Assert: check the service's behavior
        Assertions.assertThrows(
                UserNotFoundException.class,
                () -> userService.getUser(99L)
        );
    }
}
