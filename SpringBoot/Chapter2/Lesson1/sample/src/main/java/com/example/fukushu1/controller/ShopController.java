package com.example.fukushu1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.sample.Shop;
import com.example.sample.ShopService;

@Controller
@RequestMapping("/shops")
public class ShopController {
    @Autowired
    private ShopService shopService;

    @GetMapping
    public String listShops(Model model){
        List<Shop>shops = shopService.findAllShops();
        model.addAttribute("shops",shops);
        return "shops";//ビューの名前を返す 1⃣
    }
    @GetMapping("/add")
    public String addShopForm(Model model){
        model.addAttribute("shop", new Shop());
        return "add-shop";//ユーザー追加フォームのビュー
    }
    @PostMapping("/add")
    public String addShop(@ModelAttribute Shop shopB){
        shopService.saveShop(shopB);
        return "redirect:/shops";//1⃣の部分に返す
    }
}