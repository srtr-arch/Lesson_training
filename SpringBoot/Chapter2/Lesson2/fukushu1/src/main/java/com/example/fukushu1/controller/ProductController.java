package com.example.fukushu1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.fukushu1.model.Product;
import com.example.fukushu1.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public String listProduct(Model model) {
        List<Product> products = productService.findAllProducts();
        System.out.println(products.size()+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/add")
    public String addProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "add-product";
    }

    @PostMapping("/add")
     public String addProduct(@ModelAttribute Product product){
        System.out.println(product.getName()+"!!!!!");
        productService.saveProduct(product);
        return "product";
        // return "redirect:/products";
     }

}
