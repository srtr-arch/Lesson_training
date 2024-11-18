package com.example.formbindingsample.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.formbindingsample.dto.UserInput;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@RequestMapping()
@Controller
public class HomeController {
    @RequestMapping("/")
    public String form(){
        return "input";
    }
    @PostMapping("/receive")
    public String receive(@ModelAttribute UserInput userInput,Model model){
     if(userInput.getAccount().equals("a")&&userInput.getPassword().equals("b"))
     {return "success";}else{
         return form();
     }
    }
    @GetMapping
    public String index(Model model){
        model.addAttribute("userInput",new UserInput());
        return "input";
    }
    
    
}
