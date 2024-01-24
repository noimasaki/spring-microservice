package com.example.frontendwebapp.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class frontItemService {
    
    private RestTemplate restTemplate;

    public frontItemService (RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    // public String getAllItems() {
    //     String URL = "http://localhost:8081/backend/items";
    //     String items = restTemplate.getForObject(URL, String.class);

    //     return items;
    // }

    @Autowired
    WebClient webClient;

    public String getAllItems(){
        return webClient.get()
            .uri("/backend/items")
            .retrieve() // retrieveの後にレスポンスを抽出する方法を記述する
            .bodyToMono(String.class)   // String型で受け取る
            .block();   // ブロッキング
    }

}

