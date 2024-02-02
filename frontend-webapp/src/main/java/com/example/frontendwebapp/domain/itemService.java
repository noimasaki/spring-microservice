package com.example.frontendwebapp.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class itemService {
    @Autowired
    WebClient webClient;

    public String getAllItems(){
        return webClient.get()
                .uri("/backend-item/items")
                .retrieve()                 // retrieveの後にレスポンスを抽出する方法を記述する
                .bodyToMono(String.class)   // String型で受け取る
                .block();                   // ブロッキング
    }
}