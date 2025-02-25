package com.damadev.native_plant.controllers.services;

import com.damadev.native_plant.configs.PermaPeopleConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PlantService {

    private final PermaPeopleConfig config;
    private final RestTemplate restTemplate;

    @Autowired
    public PlantService(PermaPeopleConfig config, RestTemplate restTemplate) {
        this.config = config;
        this.restTemplate = restTemplate;
    }

    public String getAllPlants() {
        String url = config.getApiUrl() + "/plants";

        HttpHeaders headers = new HttpHeaders();
        headers.set("x-permapeople-key-id", config.getApiKeyId());
        headers.set("x-permapeople-key-secret", config.getApiKeySecret());

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        return response.getBody();
    }
}