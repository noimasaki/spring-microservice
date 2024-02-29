package com.example.frontendwebapp.domain;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class itemService {
    @Autowired
    WebClient webClient;

    public String getAllItems(){
        // トラッキングID生成
        String trackingId;
        trackingId = UUID.randomUUID().toString();

        return webClient.get()
                .uri("/backend-item/items")
                .header("X-Tracking-ID", trackingId)    // ヘッダーにトラッキングIDを設定
                .retrieve()                 // retrieveの後にレスポンスを抽出する方法を記述する
                .bodyToMono(String.class)   // String型で受け取る
                .block();                   // ブロッキング
    }
}