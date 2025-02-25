package com.damadev.native_plant.services;

import com.damadev.native_plant.configs.PermaPeopleConfig;
import com.damadev.native_plant.data.PlantRepository;
import com.damadev.native_plant.models.Plant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PlantService {

    private PlantRepository plantRepository;
    private final PermaPeopleConfig config;
    private final RestTemplate restTemplate;

    @Autowired
    public PlantService(PlantRepository plantRepository, PermaPeopleConfig config, RestTemplate restTemplate) {
        this.plantRepository = plantRepository;
        this.config = config;
        this.restTemplate = restTemplate;
    }

    public List<Plant> getAllPlants() {
        String url = "https://permapeople.org/api/plants";
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-permapeople-key-id", config.getApiKeyId());
        headers.set("x-permapeople-key-secret", config.getApiKeySecret());

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, entity, Map.class);

        List<Map<String, Object>> plantList = (List<Map<String, Object>>) response.getBody().get("plants");
        List<Plant> plants = new ArrayList<>();

        for (Map<String, Object> plantData : plantList) {
            String name = (String) plantData.get("name");
            String slug = (String) plantData.get("slug");
            String description = (String) plantData.get("description");
            String scientificName = (String) plantData.get("scientific_name");

            // Extract Image URL
            Map<String, String> images = (Map<String, String>) plantData.get("images");
            String imageUrl = (images != null) ? images.get("title") : null;

            // Convert "data" array into a Map<String, String>
            List<Map<String, String>> dataList = (List<Map<String, String>>) plantData.get("data");
            Map<String, String> dataMap = new HashMap<>();
            for (Map<String, String> entry : dataList) {
                dataMap.put(entry.get("key"), entry.get("value"));
            }

            Plant plant = new Plant(name, slug, dataMap, description, scientificName, imageUrl);
            plants.add(plant);
        }

        return plants;
    }


    public void savePlant(Plant plant) {
        plantRepository.save(plant);
    }

}