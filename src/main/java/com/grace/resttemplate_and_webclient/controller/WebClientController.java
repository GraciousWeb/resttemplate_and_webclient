package com.grace.resttemplate_and_webclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class WebClientController {

    private final WebClient webClient;

    @Autowired
    public WebClientController(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:9090").build();
    }

    @GetMapping("/webclient/products")
    public Mono<ResponseEntity<String>> getProducts() {
        String url = "/products";
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class)
                .map(ResponseEntity::ok);
    }
}
