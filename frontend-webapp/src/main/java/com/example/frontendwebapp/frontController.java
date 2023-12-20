package com.example.frontendwebapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class frontController {

    @GetMapping("/login")
    public String login(){
        // Thymeleafを利用しているため、記載で`/resources/templates/login.html`をreturnする
        return "login";
    }

    @GetMapping
    public String home(){
        return "home";
    }

}
