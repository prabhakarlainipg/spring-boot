package com.example.learning;

import com.example.learning.model.CreateUserRequest;
import com.example.learning.model.User;
import com.example.learning.repository.UserRepository;
import com.example.learning.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


//Integration Tests - MockMvc → Real controller → Real service proxy → Real repository → H2
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class UserIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    void createUser_persistsUserAndAllowsRetrieval() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                            {
                              "name": "Integration Alice",
                              "email": "integration-alice@example.com"
                            }
                            """))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name")
                        .value("Integration Alice"));

        List<User> matches =
                userRepository.findByName("Integration Alice");

        assertEquals(1, matches.size());
        Long id = matches.getFirst().getId();
        assertNotNull(id);

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name")
                        .value("Integration Alice"))
                .andExpect(jsonPath("$.email")
                        .value("integration-alice@example.com"));
    }

    @Test
    void failedOperation_rollsBackInsertedUser() {
        CreateUserRequest request = new CreateUserRequest(
                "Rollback User",
                "integration-rollback@example.com"
        );

        assertThrows(
                IllegalStateException.class,
                () -> userService.demonstrateRollback(request)
        );

        assertTrue(
                userRepository.findByName(request.name()).isEmpty()
        );
    }

}
