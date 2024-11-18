package com.example.fukushu3.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {
    @RequestMapping("")
    public String home() {
        return "Hello Fukushu3!"
        +"<a href='/product'>プロダクトへ<a>"
        +"<a href='/product/create'>クリエイトへ<a>"
        +"<a href='/product/details/1001'>デティールへ<a>";
    }
}
