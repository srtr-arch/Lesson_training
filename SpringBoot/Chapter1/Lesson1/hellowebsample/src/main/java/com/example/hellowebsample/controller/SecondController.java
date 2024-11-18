package com.example.hellowebsample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/slstudio")
public class SecondController {
    @RequestMapping("")
    public String index() {
        return "<h1 style='color: red;'>SLスタジオ トップページ</h1>"
                + "<a href='/slstudio/chapter01'>Chapter01ページへ</a>";
    }

    @RequestMapping("/chapter01")
    public String chapter() {
        return "<h1 style='color: blue;'>SLスタジオ チャプター０１</h1>"
                + "<a href='/slstudio'>SLスタジオトップページへ</a>";
    }
    @RequestMapping("/chapter/{number}")
    public String chapterX(@PathVariable("number")int chapterNumber){
        return "<h1 style= 'color:blue;'>SLスタジオ チャプター"
        +chapterNumber+"</h1>";
    }
}

