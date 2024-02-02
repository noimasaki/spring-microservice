package com.example.frontendwebapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    // application.ymlからプロパティservice.backendEndpointの値を取得して
    // 変数backendEndpointへ設定する
    @Value("${service.backendEndpoint}")
    private String backendEndpoint;
    
    // backendを呼び出すときの基本URIを設定
    // つまり、「/backend/items」へリクエストを送信するときに
    // 基本URIを設定して「http://xxxx.com/backend/items」へリクエストを送信する
    @Bean
    public WebClient webClient(){
        return WebClient.builder()
                .baseUrl(backendEndpoint)
                .build();
    }

}