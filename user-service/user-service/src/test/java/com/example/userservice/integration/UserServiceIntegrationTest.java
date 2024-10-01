package com.example.userservice.integration;

import com.example.userservice.entity.User;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class UserServiceIntegrationTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    void testCreateUser() {
        // Arrange
        User user = new User();
        user.setUsername("integrationUser");
        user.setEmail("integration@example.com");

        // Act
        User createdUser = userService.createUser(user);

        // Assert
        assertNotNull(createdUser.getId());
        assertEquals("integrationUser", createdUser.getUsername());
        assertEquals("integration@example.com", createdUser.getEmail());

        // Cleanup
        userRepository.deleteById(createdUser.getId());
    }
}
