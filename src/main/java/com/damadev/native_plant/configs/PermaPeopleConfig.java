package com.damadev.native_plant.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PermaPeopleConfig {

    @Value("${permapeople.api.url}")
    private String apiUrl;

    @Value("${permapeople.api.key-id}")
    private String apiKeyId;

    @Value("${permapeople.api.key-secret}")
    private String apiKeySecret;

    public String getApiUrl() {
        return apiUrl;
    }

    public String getApiKeyId() {
        return apiKeyId;
    }

    public String getApiKeySecret() {
        return apiKeySecret;
    }
}
