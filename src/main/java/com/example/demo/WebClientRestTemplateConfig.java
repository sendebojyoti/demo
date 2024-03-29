package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientRestTemplateConfig {

    //add local RestTemplate and WebClient
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public WebClient webClient() {
        return WebClient.create("https://jsonplaceholder.typicode.com");
    }
}

