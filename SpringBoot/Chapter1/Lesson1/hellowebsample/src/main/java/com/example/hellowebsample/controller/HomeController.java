package com.example.hellowebsample.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class HomeController {
    @RequestMapping("")
    public String index() {
        return "<h1>Hello, Spring Boot Web!!</h1>";
    }

    //以下を追加
    @RequestMapping("/second")
    public String index2() {
        return "<h2>Hello, Spring Boot Second Page!!</h2>";
    }
}

// package com.example.hellowebsample.controller;


// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// @RestController
// @RequestMapping("/")
// public class HomeController {
//     @RequestMapping("")
//     public String index(){
//         return"<h1>Hello,Spring Boot Web!!<h1>";
//     }
    
    // @RequestMapping("/second")
    // public String index2() {
    //     return "<h2>Hello, Spring Boot Second Page!!</h2>";
    // }
//}
