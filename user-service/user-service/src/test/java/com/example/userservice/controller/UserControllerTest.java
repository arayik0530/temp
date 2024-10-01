package com.example.userservice.controller;

import com.example.userservice.entity.User;
import com.example.userservice.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {

    @Mock
    private UserService userService;

    @Mock
    private Model model;

    @InjectMocks
    private UserController userController;

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
        when(userService.createUser(user)).thenReturn(user);

        // Act
        String viewName = userController.createUser(user, model);

        // Assert
        assertEquals("success", viewName);
        verify(userService, times(1)).createUser(user);
        verify(model, times(1)).addAttribute(eq("message"), eq("User created successfully!"));
    }
}
