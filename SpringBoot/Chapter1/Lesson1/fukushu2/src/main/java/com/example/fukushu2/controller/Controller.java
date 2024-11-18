package com.example.fukushu2.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class Controller {
    
    @RequestMapping("")
    public String index(){
        return "<h1>Helo Fukushu2!</h1>"
        +"<a href='/second'>Fukushu2 Second!へ</a>"
        +"<a href='/chapter/200'>Chapterへ</a>";
    }
    @RequestMapping("/second")
    public String index2(){
        return "<h1>Hello, Fukushu2 Second!</h1>"
        +"<a href='/'>Fukushu2!へ</a>"
        +"<a href='/chapter/100'>Chapterへ</a>";
    }
    @RequestMapping("/chapter/{num}")
    public String index3(@PathVariable("num")int chapNum){

        return "Chapter-"+chapNum+"Start"
        +"<a href='/'>Fukushu2!へ</a>"
        +"<a href='/second'>Fukushu2 Second!へ</a>";
    }

}
