package com.example.fukushu1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.fukushu1.model.Shop;
import com.example.fukushu1.service.ShopService;

@Controller
@RequestMapping("/shops")
public class ShopController {
    @Autowired
    private ShopService shopService;
    
    @GetMapping("")
    public String listShop(Model model){
        List<Shop>shops = shopService.findAllShops();
        model.addAttribute("shops", shops);
        return "shops";
    }
    @GetMapping("/add")
    public String addShopForm(Model model){
        model.addAttribute("shop", new Shop());
        return "add-shop";
    }
    @PostMapping("/add")
    public String addShop(Shop shop){
        shopService.saveShop(shop);
        return "redirect:/shops";
    }
}
