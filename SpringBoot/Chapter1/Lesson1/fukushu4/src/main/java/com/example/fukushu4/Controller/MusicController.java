package com.example.fukushu4.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/music")
@RestController
public class MusicController {
    @RequestMapping("")
    public String music(){
        return "音楽一覧ページ"
        +"<a href='/music/popular'>最新音楽一覧ページ</a>"
        +"<a href='/music/search/0'>音楽検索ページ</a>";

    }
    @RequestMapping("/popular")
    public String popular(){
        return "人気音楽一覧ページ"
        +"<a href='/music'>音楽一覧ページ</a>"
        +"<a href='/music/search/0'>音楽検索ページ</a>";

    }
    @RequestMapping("/search/{num}")
    public String search(@PathVariable("num")int num){
        return "ID"+num+"の音楽情報"
        +"<a href='/music'>音楽一覧ページ</a>"
        +"<a href='/music/popular'>人気音楽一覧ページ</a>";
    } 
    
}
