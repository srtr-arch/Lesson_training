package com.example.fukushu1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @RequestMapping("/thymeleaf")
    public String thymeleaf(Model model){
                String leaf= "Thymeleaf";
        model.addAttribute("leaf",leaf);
        return "thymeleaf";
            }
}
