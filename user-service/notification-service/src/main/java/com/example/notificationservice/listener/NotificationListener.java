package com.example.notificationservice.listener;

import com.example.notificationservice.entity.User;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationListener {

    @JmsListener(destination = "userQueue")
    public void handleUserNotification(User user) {
        // Logic to send email or log the notification
        System.out.println("Received new user: " + user.getUsername() + " with email: " + user.getEmail());
    }
}
