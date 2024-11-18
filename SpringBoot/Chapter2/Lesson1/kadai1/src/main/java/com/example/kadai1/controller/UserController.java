// package com.example.kadai1.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;

// import com.example.kadai1.model.User;
// import com.example.kadai1.service.UserService;

// @Controller
// @RequestMapping("/users")
// public class UserController {
//     @Autowired
//     private UserService userService;

//     @GetMapping()
//     public String listUser(Model model){
//         List<User>users = userService.findAllUsers();
//         model.addAttribute("users", users);
//         return "users";

//     }
//     @GetMapping("/add")
//     public String addUserForm(Model model){
//         model.addAttribute("user", new User());
//         return "add-user";
//     }
//     @PostMapping("/add")
//     public String addUser(User user){
//         userService.saveUser(user);
//         return "redirect:/users";
//     }
// }
package com.example.kadai1.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.kadai1.model.User;
import com.example.kadai1.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String index(Model model) {
        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "list";
    }

    @GetMapping("/add")
    public String addUserForm(Model model) {
        model.addAttribute("user", new User());
        return "add-user";
    }

    @PostMapping("/add")
    public String addUser(User user,Model model) {
        if(user.getName()==null||!(user.getScore1()>=0&&user.getScore1()<=100&&user.getScore2()>=0&&user.getScore2()<=100&&user.getScore3()>=0&&user.getScore3()<=100)){model.addAttribute("user",user); return "add-user";}
        userService.addUser(user);
        return "redirect:/users/list";
    }

    @GetMapping("/aggregate")
    public String aggregate(Model model){
        List<User>users = userService.findAllUsers();
        List<Integer>scores = new ArrayList<>();
        users.forEach(user->{
            scores.add(user.getScore1()+user.getScore2()+user.getScore3());
        });
        model.addAttribute("scores", scores);
        return "aggregate";
    }
}
