package com.example.frontendwebapp.domain.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class frontItemService {
    
    private RestTemplate restTemplate;

    public frontItemService (RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getAllItems() {
        String URL = "http://localhost:8081/backend/items";
        String items = restTemplate.getForObject(URL, String.class);

        return items;
    }
}

