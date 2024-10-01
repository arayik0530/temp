package com.example.userservice.service;

import com.example.userservice.entity.User;
import com.example.userservice.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jms.core.JmsTemplate;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private JmsTemplate jmsTemplate;

    @InjectMocks
    private UserService userService;

    private User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        user = new User();
        user.setUsername("testUser");
        user.setEmail("test@example.com");
    }

    @Test
    void testCreateUser() {
        // Arrange
        when(userRepository.save(user)).thenReturn(user);

        // Act
        User createdUser = userService.createUser(user);

        // Assert
        assertEquals(user.getUsername(), createdUser.getUsername());
        assertEquals(user.getEmail(), createdUser.getEmail());
        verify(jmsTemplate, times(1)).convertAndSend("userQueue", createdUser);
    }
}
