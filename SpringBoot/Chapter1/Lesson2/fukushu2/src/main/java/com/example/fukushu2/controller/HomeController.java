package com.example.fukushu2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class HomeController {
    @RequestMapping("/hello")
    public String hello(Model model){
        String hello = "Hello!";
        model.addAttribute("hello",hello);
        return "hello";
    }
}
