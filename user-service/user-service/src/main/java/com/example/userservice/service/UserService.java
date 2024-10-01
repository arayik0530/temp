package com.example.userservice.service;

import com.example.userservice.entity.User;
import com.example.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JmsTemplate jmsTemplate;

    public User createUser(User user) {
        User savedUser = userRepository.save(user);
        jmsTemplate.convertAndSend("userQueue", savedUser);
        return savedUser;
    }

    public void sendUserMessage(User user) {
        jmsTemplate.convertAndSend("userQueue", user);
    }
}
