package com.example.frontendwebapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class frontController {
    @GetMapping
    public String home(){
        return "home";
    }

    @GetMapping("/login")
    public String showLogin(){
        // Thymeleafを利用しているため、記載で`/resources/templates/login.html`をreturnする
        return "login";
    }

    @GetMapping("/logout")
    public String showLogout(){
        return "logout";
    }

    @Autowired
    private ItemService itemService;

    
    @GetMapping("/items")
    @ResponseBody
    public String showItems(){
        return itemService.getAllItems();
    }
}