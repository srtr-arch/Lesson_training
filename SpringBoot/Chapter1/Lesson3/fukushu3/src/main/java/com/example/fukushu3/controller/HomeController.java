package com.example.fukushu3.controller;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping()
@Controller
public class HomeController {
    @GetMapping("/sports")
    public String sport(){
        return "sports";
    }
    @GetMapping("/submit")
    public String submit(@RequestParam(name="sport")List<String>sports,Model model){
        model.addAttribute("sports",sports);
        return "sportslist";

    }
}
