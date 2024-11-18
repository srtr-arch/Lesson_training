package com.example.fukushu2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.fukushu2.model.User;
import com.example.fukushu2.service.TalkRoomService;
import com.example.fukushu2.service.UserService;

import jakarta.persistence.EntityNotFoundException;

@Controller
@RequestMapping("users")
public class UserHandler {
    @Autowired
    private UserService userService;
    @Autowired
    private TalkRoomService talkRoomService;

    @GetMapping
    public String listUser(Model model) {
        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users/list";
    }

    @GetMapping("/add")
    public String addUserForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("talkrooms",talkRoomService.findAllTalkRooms());
        
        return "users/add";
    }

    @PostMapping("/add")
    public String addUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable("id") Long id,Model model) {
        User user = userService.findUserById(id).orElseThrow(() -> new EntityNotFoundException());
        model.addAttribute("user",user);
        return "users/edit";
    }

    @GetMapping("/edit")
    public String editUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";

    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id")Long id,Model model){
        System.out.println(id+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        User user = userService.findUserById(id).orElseThrow(() -> new EntityNotFoundException());
        user.setDeleted(true);
        userService.saveUser(user);
        return "redirect:/users";
    }

}
