package com.example.fukushu3.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductsController {
    @RequestMapping("")
    public String product(){
        return "Show Products!"
        +"<a href='/'>ホームへ</a>"
        +"<a href='/product/create'>クリエイトへ</a>"
        +"<a href='product/details/1001'>デティールへ</a>";

    }
    @RequestMapping("/create")
    public String create(){
        return "Create New Product!"
        +"<a href='/product'>プロダクトへ</a>"
        +"<a href='/'>ホームへ</a>"
        +"<a href='/product/details/1001'>ディテールへ</a>";
    }
    @RequestMapping("/details/{num}")
    public String detail(@PathVariable("num") int num){
        return "Product Details ("+num+")!"
        +"<a href='/'>ホームへ</a>"
        +"<a href='/product'>プロダクトへ</a>"
        +"<a href='/product/create'>クリエイトへ</a>";
    }
}
