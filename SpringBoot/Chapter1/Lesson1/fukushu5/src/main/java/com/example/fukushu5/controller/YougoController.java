package com.example.fukushu5.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/yougo")
@RestController
public class YougoController {
    @RequestMapping("")
    public String you(){
        return "用語トップページ"
        +"<a href='/yougo/springboot'>springboot</a>"
        +"<a href='/yougo/localhost'>ローカルホスト</a>"
        +"<a href='/yougo/controller'>コントローラー</a>"
        +"<a href='/yougo/framework'>フレームワーク</a>";

    }
    @RequestMapping("/springboot")
    public String springboot(){
        return "1. Spring Bootはフレームワークです"
        +"<a href='/yougo'>用語トップページ</a>"
        +"<a href='/yougo/localhost'>ローカルホスト</a>"
        +"<a href='/yougo/controller'>コントローラー</a>"
        +"<a href='/yougo/framework'>フレームワーク</a>";

    }
    @RequestMapping("/localhost")
    public String localhost(){
        return "2. localhostは自分のPCへのドメイン名です"
        +"<a href='/yougo'>用語トップページ</a>"
        +"<a href='/yougo/springboot'>springboot</a>"
        +"<a href='/yougo/controller'>コントローラー</a>"
        +"<a href='/yougo/framework'>フレームワーク</a>";

    }
    @RequestMapping("/controller")
    public String controller(){
        return "3. ControllerはURLのアクセスと紐づけるJavaのクラスです"
        +"<a href='/yougo'>用語トップページ</a>"
        +"<a href='/yougo/localhost'>ローカルホスト</a>"
        +"<a href='/yougo/springboot'>springboot</a>"
        +"<a href='/yougo/framework'>フレームワーク</a>";

    }
    @RequestMapping("/framework")
    public String framework(){
        return "4. frameworkはSpring Boot以外にも沢山あります"
        +"<a href='/yougo'>用語トップページ</a>"
        +"<a href='/yougo/localhost'>ローカルホスト</a>"
        +"<a href='/yougo/springboot'>springboot</a>"
        +"<a href='/yougo/controller'>コントローラー</a>";

    }
    @RequestMapping("/search/{num}")
    public String search(@PathVariable("num") int num){
        if(num==1)  return springboot();
        if(num==2)  return controller();
        return "";
    }

}
