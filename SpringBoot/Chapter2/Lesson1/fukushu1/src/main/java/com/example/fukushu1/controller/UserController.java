package com.example.fukushu1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.fukushu1.model.User;
import com.example.fukushu1.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired 
    private UserService userService;

    @GetMapping("")
    public String listUser(Model model){
        List<User>users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/add")
    public String addUserForm(Model model) {
        model.addAttribute("user", new User());
        return "add-user";
    }
    @PostMapping("/add")
    public String addUser(User user){
        userService.saveUser(user);
        return "redirect:/users";
    }
}
