package com.grace.resttemplate_and_webclient.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestTemplateController {

    private final RestTemplate restTemplate;

    public RestTemplateController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/resttemplate/products")
    public ResponseEntity<String> getProducts() {
        String url = "http://localhost:9090/resttemplate/products";
        String response = restTemplate.getForObject(url, String.class);
        return ResponseEntity.ok(response);
    }
}

