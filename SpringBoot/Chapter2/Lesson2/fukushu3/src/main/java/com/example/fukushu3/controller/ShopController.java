package com.example.fukushu3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.fukushu3.model.Shop;
import com.example.fukushu3.service.ShopService;


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
    public String addShop(@ModelAttribute Shop shop){
        shopService.saveShop(shop);
        return "redirect:/shops";
    }
    @GetMapping("/delete/{id}")
    public String deleteShop(@PathVariable("id")Long id){
        Optional<Shop>optionalShop = shopService.findShopById(id);
        if(optionalShop.isPresent()){
            Shop shop = optionalShop.get();
            shop.setDeleted(true);
            shopService.saveShop(shop);
        }
        return "redirect:/shops";
    }
    @GetMapping("/edit/{id}")
    public String editShopForm(@PathVariable("id")Long id,Model model){
        Optional<Shop>optionalShop = shopService.findShopById(id);
        if(optionalShop.isPresent()){
            Shop shop = optionalShop.get();
            model.addAttribute("shop", shop);
            return "shops/edit";
        }
        return "redirect:/shops";
        
    }
    @PostMapping("/edit")
    public String editShop(Shop shop) {
        shopService.saveShop(shop);
        return "redirect:/shops";
        
    }
    @GetMapping("/search")
    public String searchShopsForm(@RequestParam(name="name",required = false)String name,Model model){
        
        List<Shop>shops = shopService.findShopsByName("%"+name);
        model.addAttribute("shops",shops);
        return "/shops/search";
    }
    
}
