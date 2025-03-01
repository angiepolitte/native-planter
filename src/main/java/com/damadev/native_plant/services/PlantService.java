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

    public void fetchAndSavePlants() {
        String url = config.getApiUrl() + "/plants";

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
            String usdaHardinessZone = (String) plantData.get("usda_hardiness_zone");
            String lifeCycle = (String) plantData.get("life_cycle");
            String lightRequirement = (String) plantData.get("light_requirement");
            String waterRequirement = (String) plantData.get("water_requirement");
            String soilType = (String) plantData.get("soil_type");
            String height = (String) plantData.get("height");
            String width = (String) plantData.get("width");
            String layer = (String) plantData.get("layer");
            boolean isEdible = plantData.get("is_edible") != null && (boolean) plantData.get("is_edible");
            boolean isNativeTo = plantData.get("is_native_to") != null && (boolean) plantData.get("is_native_to");
            String type = (String) plantData.get("type");

            // Image URL
            String imageUrl = (plantData.containsKey("images") && plantData.get("images") instanceof Map)
                    ? ((Map<String, String>) plantData.get("images")).get("title")
                    : null;

            Plant plant = new Plant(null, name, slug, imageUrl, usdaHardinessZone, lifeCycle, lightRequirement, waterRequirement,
                    soilType, height, width, layer, isEdible, isNativeTo, type);

            plants.add(plant);
        }

        plantRepository.saveAll(plants); // Save all plants to the database
    }

    public List<Plant> getStoredPlants() {
        return (List<Plant>) plantRepository.findAll();
    }
}