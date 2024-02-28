package com.example.frontendwebapp.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.frontendwebapp.app.TrackingFilter;

@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean<TrackingFilter> trackingFilter() {
        FilterRegistrationBean<TrackingFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new TrackingFilter());
        registrationBean.addUrlPatterns("/*"); // すべてのURLパターンに適用
        return registrationBean;
    }

}
