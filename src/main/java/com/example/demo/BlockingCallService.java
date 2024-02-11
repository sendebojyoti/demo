package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
public class BlockingCallService {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(BlockingCallService.class);

    private final WebClient webClient;
    private final RestTemplate restTemplate;

    public BlockingCallService(WebClient webClient, RestTemplate restTemplate) {
        this.webClient = webClient;
        this.restTemplate = restTemplate;
    }

    // Using Web
    // Client for making a blocking call
    public String webClientBlockingCall() {
        long startTime = System.currentTimeMillis();
        String response = webClient.get()
                .uri("/posts/1")
                .retrieve()
                .bodyToMono(String.class)
                .block(); // Blocking call
        long endTime = System.currentTimeMillis();
        log.info("Web Template Time: " + (endTime - startTime));

        return "Response from WebClient: " + response;
    }

    // Using RestTemplate for making a blocking call

    public String restTemplateBlockingCall() {
        RestTemplate restTemplate = new RestTemplate();
        long startTime = System.currentTimeMillis();
        String response = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/1", String.class);
        long endTime = System.currentTimeMillis();
        log.info("Rest Template Time: " + (endTime - startTime));

        return "Response from RestTemplate: " + response;
    }
}
