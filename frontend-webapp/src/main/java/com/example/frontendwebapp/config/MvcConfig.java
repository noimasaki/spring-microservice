package com.example.frontendwebapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestOperations;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.frontendwebapp.app.web.ServiceProperties;

@Configuration
@ComponentScan("com.example.frontendwebapp.app.web")    //Controllerクラスは別ディレクトリなので読み込んであげる
public class MvcConfig implements WebMvcConfigurer{
    
    // backendを呼び出すときの基本URIをServicePropertiesから取得する
    // つまり、「/backend/items」へリクエストを送信するときに
    // getDns()メソッドで取得した基本URIを設定して「http://xxxx.com/backend/items」へリクエストを送信する
    @Autowired
    ServiceProperties properties;

    @Bean
    public RestOperations restOperations(RestTemplateBuilder restTemplateBuilder){
        return restTemplateBuilder.rootUri(properties.getDns()).build();
    }
}
