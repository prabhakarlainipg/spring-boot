package com.example.learning.service;

import com.example.learning.exception.UserNotFoundException;
import com.example.learning.model.CreateUserRequest;
import com.example.learning.model.User;
import com.example.learning.model.UserResponse;
import com.example.learning.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

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

    @Test
    void getUser_whenUserExists_returnsUserDetails() throws UserNotFoundException {
        // Arrange
        User user = new User("Prabhakar", "prabhakar@example.com");

        when(userRepository.findById(42L))
                .thenReturn(Optional.of(user));

        // Act
        UserResponse response = userService.getUser(42L);

        // Assert
        assertEquals("Prabhakar", response.name());
        assertEquals("prabhakar@example.com", response.email());

        verify(userRepository).findById(42L);
    }


    @Test
    void createUser_whenRequestIsValid_savesUserAndReturnsResponse() {
        CreateUserRequest request =
                new CreateUserRequest("Alice", "alice@example.com");

        // Represents the entity returned after persistence.
        User savedUser = mock(User.class);
        when(savedUser.getId()).thenReturn(10L);
        when(savedUser.getName()).thenReturn("Alice");
        when(savedUser.getEmail()).thenReturn("alice@example.com");

        when(userRepository.save(any(User.class)))
                .thenReturn(savedUser);

        UserResponse response = userService.createUser(request);

        // Inspect the actual entity passed to save().
        ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);
        verify(userRepository).save(captor.capture());

        User submittedUser = captor.getValue();

        assertEquals("Alice", submittedUser.getName());
        assertEquals("alice@example.com", submittedUser.getEmail());

        // Check the response uses the saved entity.
        assertEquals(10L, response.id());
        assertEquals("Alice", response.name());
        assertEquals("alice@example.com", response.email());
    }
}
