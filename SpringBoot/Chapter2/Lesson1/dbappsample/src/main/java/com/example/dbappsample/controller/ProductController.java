// package com.example.dbappsample.controller;

// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;

// import com.example.dbappsample.model.Product;

// @Controller
// @RequestMapping("/products")
// public class ProductController {

//     @GetMapping("/add")
//     public String addProductForm(Model model){
//         model.addAttribute("product", new Product() );
//         return "add-product";
//     }
    
// }
package com.example.dbappsample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dbappsample.model.Product;
import com.example.dbappsample.repository.ProductRepository;
import com.example.dbappsample.service.ProductService;


@Controller
@RequestMapping("/products")
public class ProductController {
@Autowired 
private ProductRepository productRepository;
@Autowired
private ProductService productService;

    @GetMapping("")
    public String listProducts(Model model){
        List<Product>products = productService.findAllProducts();
        model.addAttribute("products",products);
        return "products";
    }
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
    @PostMapping("/add")
    public String addProductForm(Product product) {
        productService.saveProduct(product);
        return "redirect:/products/add";
    }
    @GetMapping("/add")
    public String addProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "add-product";
    }
}