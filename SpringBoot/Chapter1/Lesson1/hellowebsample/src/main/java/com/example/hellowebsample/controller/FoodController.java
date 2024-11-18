package com.example.hellowebsample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/foods")
public class FoodController {
    @RequestMapping("")
    public String list(){
        return "食品の一覧はこちら";
    }
    
}
