package com.example.notificationservice.listener;

import com.example.notificationservice.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

class NotificationListenerTest {

    @InjectMocks
    private NotificationListener notificationListener;

    private User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        user = new User();
        user.setUsername("testUser");
        user.setEmail("test@example.com");
    }

    @Test
    void testHandleUserNotification() {
        // Act
        notificationListener.handleUserNotification(user);

        // No Assert needed, as we are just verifying that the method executes without errors
    }
}
