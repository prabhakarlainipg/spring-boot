package com.example.learning.repository;

import com.example.learning.model.User;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;


//- After the test, Spring rolls back that transaction.
@DataJpaTest
//Spring creates a JPA test context
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private EntityManager entityManager;


    @Test
    void saveUser_canReadItBackFromDatabase() {
        User savedUser = userRepository.saveAndFlush(
                new User("Alice", "alice@example.com")
        );

        String id = String.valueOf(savedUser.getId());
        Assertions.assertNotNull(id);

        // Clear managed entities so the lookup reads from the database.
        entityManager.clear();

        User foundUser = userRepository.findById(Long.valueOf(id))
                .orElseThrow();

        Assertions.assertEquals("Alice", foundUser.getName());
        Assertions.assertEquals("alice@example.com", foundUser.getEmail());
    }

}
