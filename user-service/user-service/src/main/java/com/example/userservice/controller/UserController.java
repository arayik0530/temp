package com.example.userservice.controller;

import com.example.userservice.entity.User;
import com.example.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/create")
    public String showCreateUserForm(User user) {
        return "createUser"; // JSF view createUser.xhtml
    }

    @PostMapping("/create")
    public String createUser(User user, Model model) {
        userService.createUser(user);
        model.addAttribute("message", "User created successfully!");
        return "success";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // This should match your JSF page name
    }
}
