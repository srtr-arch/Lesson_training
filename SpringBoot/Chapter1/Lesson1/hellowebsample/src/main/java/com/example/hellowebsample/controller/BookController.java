package com.example.hellowebsample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")

public class BookController {
    @RequestMapping("")
    public String list(){
        return "書籍の一覧はこちら";
    }

    @RequestMapping("/programing")
    public String programmingList(){
        return "プログラミング書籍の一覧はこちら";
    }
    
}
