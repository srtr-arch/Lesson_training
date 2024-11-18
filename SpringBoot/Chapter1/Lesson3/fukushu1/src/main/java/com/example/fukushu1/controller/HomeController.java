package com.example.fukushu1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping()
@Controller
public class HomeController {
    @RequestMapping("")
    public String index(@RequestParam(name = "num1", required = false, defaultValue = "1") int num1,
            @RequestParam(name = "num2", required = false, defaultValue = "1") int num2, Model model) {
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        return "num";
    }

    @GetMapping("/itemlist")
    public String item(@RequestParam(name = "item1", required = false, defaultValue = "a") String item1,
            @RequestParam(name = "item2", required = false, defaultValue = "a") String item2,
            @RequestParam(name = "item3", required = false, defaultValue = "a") String item3, Model model) {
        List<String> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        model.addAttribute("items", items);
        return "items";
    }
    @GetMapping("/showform")
    public String showForm(){
        return "form";
    }
    @GetMapping("/submit")
    public String output(@RequestParam(name="name" ,required=true)String name,@RequestParam(name="comment",required=false,defaultValue="")String comment,Model model){
        model.addAttribute("name", name);
        model.addAttribute("comment", comment);
        return "output";
    }
}
