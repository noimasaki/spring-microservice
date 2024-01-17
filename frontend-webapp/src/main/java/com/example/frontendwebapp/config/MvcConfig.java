package com.example.frontendwebapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("com.example.frontendwebapp.app.web")    //Controllerクラスは別ディレクトリなので読み込んであげる
public class MvcConfig implements WebMvcConfigurer{
    
}
