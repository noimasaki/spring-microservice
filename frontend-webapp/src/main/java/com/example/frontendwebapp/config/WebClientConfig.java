package com.example.frontendwebapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.frontendwebapp.app.web.ServiceProperties;

@Configuration
@ComponentScan("com.example.frontendwebapp.app.web")    //Controllerクラスは別ディレクトリなので読み込んであげる

public class WebClientConfig {
    // backendを呼び出すときの基本URIをServicePropertiesから取得する
    // つまり、「/backend/items」へリクエストを送信するときに
    // getDns()メソッドで取得した基本URIを設定して「http://xxxx.com/backend/items」へリクエストを送信する

    @Autowired
    ServiceProperties serviceProperties;
    
    @Bean
    public WebClient webClient(){
        return WebClient.builder()
            .baseUrl(serviceProperties.getDns())
            .build();
    }
    
}
