package com.example.fukushu3.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.fukushu3.Product;

@Controller
@RequestMapping("/")
public class HomeController {
    @RequestMapping("/currenttime")
    public String current(Model model){
        boolean showMessage = false;
        LocalDateTime now = LocalDateTime.now();
        int score = 0;
        String judgement = "";
        if(score>=80){
            judgement="合格";
        }else{judgement="不合格";}
        List<Integer>items = new ArrayList<>();
        items.add(0);
        List<String>users = new ArrayList<>();
        users.add("田中");
        users.add("山本");
        // List<Integer>numbers = new ArrayList<>();
        // numbers.add(8);
        // numbers.add(10);
        List<Double>numbers = new ArrayList<>();
        numbers.add(8.0);
        numbers.add(10.0);
        List<Product>products = new ArrayList<>();
        products.add(new Product("a",100));
        List<Person>people = new ArrayList<>();
        people.add(new Person("a",100));
        people.add(new Person("b",200));
        model.addAttribute("now",now);
        model.addAttribute("bool",showMessage);
        model.addAttribute("judgement",judgement);
        model.addAttribute("score",score);
        model.addAttribute("items",items);
        model.addAttribute("users",users);
        model.addAttribute("numbers",numbers);
        model.addAttribute("products",products);
        model.addAttribute("people",people);
        return "currenttime";

    }

}
