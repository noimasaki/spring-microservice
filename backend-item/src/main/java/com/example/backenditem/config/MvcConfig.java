package com.example.backenditem.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("com.example.backenditem.app.web")   //Controllerクラスは別ディレクトリなので読み込んであげる
public class MvcConfig implements WebMvcConfigurer{
    
}
