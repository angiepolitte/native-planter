package com.damadev.native_plant.controllers.services;

import com.damadev.native_plant.models.Plant;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PlantApiService {
    private final String API_URL = "https://perenual.com/api/species-list";
    private final String API_KEY = "sk-vnyO67ba08a1348818792";

    private final RestTemplate restTemplate = new RestTemplate();


    public List<Plant> fetchPlants() {
        String url = UriComponentsBuilder.fromHttpUrl(API_URL)
                .queryParam("key", API_KEY)
                .toUriString();

        Map<String, Object> response = restTemplate.getForObject(url, Map.class);
        List<Map<String, Object>> data = (List<Map<String, Object>>) response.get("data");

        List<Plant> plants = new ArrayList<>();

        for (Map<String, Object> plantData : data) {
            int id = (plantData.get("id") instanceof Number) ? ((Number) plantData.get("id")).intValue() : 0;
            String commonName = (String) plantData.getOrDefault("common_name", "Unknown");

            List<String> scientificNames = (List<String>) plantData.get("scientific_name");
            String scientificName = (scientificNames != null && !scientificNames.isEmpty()) ? scientificNames.get(0) : "N/A";

            String cycle = (String) plantData.getOrDefault("cycle", "Unknown");
            String watering = (String) plantData.getOrDefault("watering", "Unknown");

            Map<String, Object> hardiness = (Map<String, Object>) plantData.get("hardiness");
            String hardinessMin = hardiness != null ? String.valueOf(hardiness.getOrDefault("min", "N/A")) : "N/A";
            String hardinessMax = hardiness != null ? String.valueOf(hardiness.getOrDefault("max", "N/A")) : "N/A";

            boolean isEdible = Boolean.TRUE.equals(plantData.get("edible"));

            plants.add(new Plant(id, commonName, scientificName, cycle, watering, hardinessMin, hardinessMax, isEdible));
        }

        return plants;
    }
}

//    public List<Plant> fetchPlants() {
//        String url = UriComponentsBuilder.fromHttpUrl(API_URL)
//                .queryParam("key", API_KEY)
//                .toUriString();
//
//        Map<String, Object> response = restTemplate.getForObject(url, Map.class);
//        List<Map<String, Object>> data = (List<Map<String, Object>>) response.get("data");
//
//        List<Plant> plants = new ArrayList<>();
//
//        for (Map<String, Object> plantData : data) {
//            int id = (int) plantData.get("id");
//            String commonName = (String) plantData.get("common_name");
//            List<String> scientificNames = (List<String>) plantData.get("scientific_name");
//            String scientificName = (scientificNames != null && !scientificNames.isEmpty()) ? scientificNames.get(0) : "N/A";
//            String cycle = (String) plantData.get("cycle");
//            String watering = (String) plantData.get("watering");
//
//            Map<String, Object> hardiness = (Map<String, Object>) plantData.get("hardiness");
//            String hardinessMin = hardiness != null ? String.valueOf(hardiness.get("min")) : "N/A";
//            String hardinessMax = hardiness != null ? String.valueOf(hardiness.get("max")) : "N/A";
//
//            boolean isEdible = plantData.get("edible") != null && (boolean) plantData.get("edible");
//
//            plants.add(new Plant(id, commonName, scientificName, cycle, watering, hardinessMin, hardinessMax, isEdible));
//        }
//
//        return plants;
//    }

//    public List<Map<String, Object>> fetchPlants() {
//        String url = UriComponentsBuilder.fromHttpUrl(API_URL)
//                .queryParam("key", API_KEY)
//                .toUriString();
//
//        Map<String, Object> response = restTemplate.getForObject(url, Map.class);
//
//        return (List<Map<String, Object>>) response.get("data");
//    }
//}
