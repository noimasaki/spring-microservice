package com.example.frontendwebapp.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.frontendwebapp.domain.service.frontItemService;

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
    private frontItemService frontItemService;

    @GetMapping("/items")
    @ResponseBody
    // 【@ResponseBody】
    // Thymeleafを利用しているため、Stringでreturnしてしまうとhtmlファイル名であると解釈してしまうため、
    // htmlファイルではなくてレスポンス本文であることを明示的にするアノテーション
    public String showItems(){
        return frontItemService.getAllItems();
    }
}
