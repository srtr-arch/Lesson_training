package com.example.fukushu2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.fukushu2.dto.UserInput;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping()
@Controller
public class HomeController {
    @RequestMapping("")
    public String home(Model model) {
        model.addAttribute("userInput", new UserInput());
        return "register";
    }
    @GetMapping("/loginform")
    public String login(Model model){
        model.addAttribute("userInput",new UserInput());
        return "login";

    }
    @PostMapping("/top")
    public String top(@ModelAttribute UserInput userInput){
        if(userInput.getMail().equals("keycat@slstudio.com")&&userInput.getPassword().equals("slstudio")){
            return "top";
        }else{return "login";}
    }
    
    

    @RequestMapping("/regist")
    public String regist(@ModelAttribute UserInput userInput, Model model) {
        if (userInput.getFirstName() == "" || userInput.getLastName() == "" || userInput.getMail() == ""
                || userInput.getPassword() == "") {
            return "register";
        } else {
            model.addAttribute("userInput", userInput);
            return "success";
        }
    }
}
