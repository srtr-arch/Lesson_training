package com.example.fukushu1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/")
public class Controller {
    @RequestMapping("")
    public String index(){
        return "<h1>Hello,Fukushu1!</h1>";
    }
}
