package com.example.learning.controller;

import com.example.learning.exception.UserNotFoundException;
import com.example.learning.model.UserResponse;
import com.example.learning.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//loads the controller and relevant web infrastructure.
//tests URL routing, HTTP status codes and JSON responses without opening a real server port
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    //supplies a mock service inside Spring’s test context.
    @MockitoBean
    private UserService userService;

    @Test
    void getUser_whenUserExists_returns200AndUserJson() throws Exception {
        when(userService.getUser(42L))
                .thenReturn(new UserResponse(
                        42L,
                        "Alice",
                        "alice@example.com"
                ));

        mockMvc.perform(MockMvcRequestBuilders.get("/users/42"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.id").value(42))
                .andExpect(jsonPath("$.name").value("Alice"))
                .andExpect(jsonPath("$.email")
                        .value("alice@example.com"));
    }

    @Test
    void getUser_whenUserMissing_returns404() throws Exception {
        when(userService.getUser(99L))
                .thenThrow(new UserNotFoundException(99L));

        mockMvc.perform(MockMvcRequestBuilders.get("/users/99"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message")
                        .value("User not found with ID: 99"));
    }

}
