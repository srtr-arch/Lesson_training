package com.example.thymeleafsample.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class HomeController {
    @RequestMapping("")
    public String index(Model model){
        LocalDateTime now = LocalDateTime.now();
        model.addAttribute("message",now);
        return "home";
    }
}
