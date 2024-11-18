package com.example.httprequestsmple.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.httprequestsmple.dto.UserForm;

@RequestMapping("/")
@Controller
public class HomeController {
    @GetMapping("")
    public String index(@RequestParam(name="keyword",required=false,defaultValue="なし")String str,Model model){
        model.addAttribute("message", str);
        return "index";
    }

    @PostMapping("/many")
    public String manyQueryParam(
        @RequestParam(name="name",required=false,defaultValue="名無し")String name,@RequestParam(name="age" ,required= false,defaultValue="100")int age,@RequestParam(name="address",required=false,defaultValue="地球")String address,Model model
    ){model.addAttribute("name", name);
    model.addAttribute("age", age);
    model.addAttribute("address", address);
        String message="18歳以上なので成人です";
        if(age<18){
            message="18歳未満なので未成年です";
        }
        model.addAttribute("message", message);
        return "many";
    }

    @PostMapping("/postmany")
    public String submitForm(@ModelAttribute UserForm userForm,Model model){
        model.addAttribute("userInput",userForm);
        return "success";
    }
    @GetMapping("/form")
    public String showForm(Model model){
        return "show-form";
    }

    @GetMapping("/form2")
    public String index(){
        return "showForm2";
    }

    @GetMapping("/multi")
    public String multi(Model model,@RequestParam(name="fruits")List<String>fruits){
        model.addAttribute("fruits",fruits);
        return "fruits";
    }


}