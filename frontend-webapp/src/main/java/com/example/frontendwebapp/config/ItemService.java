package com.example.frontendwebapp.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ItemService {
    
    private RestTemplate restTemplate;

    public ItemService (RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getAllItems() {
        String URL = "http://localhost:8081/backend/items";
        String items = restTemplate.getForObject(URL, String.class);

        return items;
    }
}
