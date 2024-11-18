package com.example.thymeleafsample.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lesson")
public class LessonController {
    @RequestMapping("")
    public String index(){
        return "lesson/index";
    }
    @RequestMapping("/if-unless")
    public String ifunless(Model model){
        model.addAttribute("show",true);
        return "lesson/if-unless-sample";
    }
    @RequestMapping("/each")
    public String list(Model model){
        model.addAttribute("items",List.of("Item1","Item2","item3"));
        return "lesson/each-sample";
    }

    @RequestMapping("/products")
    public String showProducts(Model model){
        List<Product>products = Arrays.asList(
            new Product("商品A",1000.0),
            new Product("商品B",1500.0),
            new Product("商品C",2000.0)
        );
        model.addAttribute("products",products);
        return "lesson/products-each-sample";
    }

    @RequestMapping("/check-list")
    public String checkList(Model model){
        List<String>list = new ArrayList<>();
        model.addAttribute("myList",list);
        return "lesson/check-list-sample";
    }
    @RequestMapping("/aggregates")
    public String showNumbers(Model model){
        List<Integer>numbers = Arrays.asList(10,20,30,40,50);
        model.addAttribute("numbers",numbers);
        return "lesson/aggregates-sample";
    }
    @RequestMapping("/upper-case")
    public String upperCase(Model model){
        String myString = "hello world";
        model.addAttribute("myString",myString);
        return "lesson/upper-case-sample";
    }
    @RequestMapping("/format-datetime")
    public String formatDate(Model model){
        LocalDateTime now = LocalDateTime.now();
        model.addAttribute("now",now);
        return "lesson/format-datetime-sample";
    }
}
