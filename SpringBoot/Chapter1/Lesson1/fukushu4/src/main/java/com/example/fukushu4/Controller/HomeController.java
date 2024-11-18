package com.example.fukushu4.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
    @RestController
public class HomeController {
    
    @RequestMapping("")
    public String HController(){
        return "Spring Bootプロジェクトへようこそ";
    }
}
