package com.damadev.native_plant.services;

import com.damadev.native_plant.configs.PermaPeopleConfig;
import com.damadev.native_plant.data.PlantRepository;
import com.damadev.native_plant.models.Plant;
import com.damadev.native_plant.models.dto.PlantResponseDTO;
import jakarta.transaction.Transactional;
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

    public Plant savePlant(Plant plant) {
        return plantRepository.save(plant);
    }

    // Cleaned-up version to fetch a limited number of plants
    @Transactional
    public void fetchAndStorePlants(int limit) {
        String url = config.getApiUrl() + "/plants";

        HttpHeaders headers = new HttpHeaders();
        headers.set("x-permapeople-key-id", config.getApiKeyId());
        headers.set("x-permapeople-key-secret", config.getApiKeySecret());

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<PlantResponseDTO> response = restTemplate.exchange(url, HttpMethod.GET, entity, PlantResponseDTO.class);

        List<PlantResponseDTO.PlantData> plantList = response.getBody().getPlants();
        int count = 0;

        for (PlantResponseDTO.PlantData plantData : plantList) {
            if (count >= limit) break;  // Stop after fetching the specified limit
            count++;

            // Map the plant data to the Plant model
            Plant plant = new Plant(
                    null,
                    plantData.getName(),
                    plantData.getSlug(),
                    plantData.getImageUrl(),
                    plantData.getUsdaHardinessZone(),
                    plantData.getLifeCycle(),
                    plantData.getLightRequirement(),
                    plantData.getWaterRequirement(),
                    plantData.getSoilType(),
                    plantData.getHeight(),
                    plantData.getWidth(),
                    plantData.getLayer(),
                    plantData.getNativeTo(),  // Directly use nativeTo as String
                    plantData.isEdible(),  // Use boolean directly
                    plantData.getType()
            );

            plantRepository.save(plant);
        }
    }

    public List<Plant> getAllPlants() {
        return (List<Plant>) plantRepository.findAll();
    }
}
//    @Autowired
//    public PlantService(PlantRepository plantRepository, PermaPeopleConfig config, RestTemplate restTemplate) {
//        this.plantRepository = plantRepository;
//        this.config = config;
//        this.restTemplate = restTemplate;
//    }
//    public Plant savePlant(Plant plant) {
//        return plantRepository.save(plant);
//    }
//
//    public void fetchAndStorePlants(int limit) {
//        String url = config.getApiUrl() + "/plants";
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("x-permapeople-key-id", config.getApiKeyId());
//        headers.set("x-permapeople-key-secret", config.getApiKeySecret());
//
//        HttpEntity<String> entity = new HttpEntity<>(headers);
//        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, entity, Map.class);
//
//        List<Map<String, Object>> plantList = (List<Map<String, Object>>) response.getBody().get("plants");
//
//        int count = 0;
//        for (Map<String, Object> plantData : plantList) {
//            if (count >= limit) break;  // Stop after fetching the specified limit
//            count++;
//
//            Integer id = (Integer) plantData.get("id");
//            String commonName = (String) plantData.get("name");
//            String slug = (String) plantData.get("slug");
//
//            // Extract Image URL
//            Map<String, String> images = (Map<String, String>) plantData.get("images");
//            String imageUrl = (images != null) ? images.get("title") : null;
//
//            // Extract additional attributes from "data"
//            List<Map<String, String>> dataList = (List<Map<String, String>>) plantData.get("data");
//            Map<String, String> dataMap = new HashMap<>();
//            for (Map<String, String> entry : dataList) {
//                dataMap.put(entry.get("key"), entry.get("value"));
//            }
//
//
//            Plant plant = new Plant(
//                    id,
//                    commonName,
//                    slug,
//                    imageUrl,
//                    dataMap.getOrDefault("USDA Hardiness zone", null),
//                    dataMap.getOrDefault("Life cycle", null),
//                    dataMap.getOrDefault("Light Requirement", null),
//                    dataMap.getOrDefault("Water Requirement", null),
//                    dataMap.getOrDefault("Soil Type", null),
//                    dataMap.getOrDefault("Height", null),
//                    dataMap.getOrDefault("Width", null),
//                    dataMap.getOrDefault("Layer", null),
//                    Boolean.parseBoolean(dataMap.getOrDefault("Edible", "false")), // Parse as boolean
//                    dataMap.getOrDefault("Native to", "Unknown"),
//                    dataMap.getOrDefault("Type", null)
//            );
//
//            plantRepository.save(plant);
//        }
//    }
//
//    public List<Plant> getAllPlants() {
//        return (List<Plant>) plantRepository.findAll();
//    }
//}
//@Service
//public class PlantService {
//
//    private PlantRepository plantRepository;
//    private final PermaPeopleConfig config;
//    private final RestTemplate restTemplate;
//
//    @Autowired
//    public PlantService(PlantRepository plantRepository, PermaPeopleConfig config, RestTemplate restTemplate) {
//        this.plantRepository = plantRepository;
//        this.config = config;
//        this.restTemplate = restTemplate;
//    }
//
//    public void savePlant(Plant plant) {
//        plantRepository.save(plant);
//    }
//
//
//    public void fetchAndStorePlants(int limit) {
//        String url = config.getApiUrl() + "/plants";
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("x-permapeople-key-id", config.getApiKeyId());
//        headers.set("x-permapeople-key-secret", config.getApiKeySecret());
//
//        HttpEntity<String> entity = new HttpEntity<>(headers);
//        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, entity, Map.class);
//
//        List<Map<String, Object>> plantList = (List<Map<String, Object>>) response.getBody().get("plants");
//
//        int count = 0;
//        for (Map<String, Object> plantData : plantList) {
//            if (count >= limit) break;  // Stop after fetching the specified limit
//            count++;
//
//            Integer id = (Integer) plantData.get("id");
//            String commonName = (String) plantData.get("name");
//            String slug = (String) plantData.get("slug");
//
//            // Extract Image URL
//            Map<String, String> images = (Map<String, String>) plantData.get("images");
//            String imageUrl = (images != null) ? images.get("title") : null;
//
//            // Extract additional attributes from "data"
//            List<Map<String, String>> dataList = (List<Map<String, String>>) plantData.get("data");
//            Map<String, String> dataMap = new HashMap<>();
//            for (Map<String, String> entry : dataList) {
//                dataMap.put(entry.get("key"), entry.get("value"));
//            }



//
//            Plant plant = new Plant(
//                    id,
//                    commonName,
//                    slug,
//                    imageUrl,
//                    dataMap.getOrDefault("USDA Hardiness zone", null),
//                    dataMap.getOrDefault("Life cycle", null),
//                    dataMap.getOrDefault("Light Requirement", null),
//                    dataMap.getOrDefault("Water Requirement", null),
//                    dataMap.getOrDefault("Soil Type", null),
//                    dataMap.getOrDefault("Height", null),
//                    dataMap.getOrDefault("Width", null),
//                    dataMap.getOrDefault("Layer", null),
//                    dataMap.getOrDefault("Edible", "false"),
//                    dataMap.getOrDefault("Native to", "Unknown"),
//                    dataMap.getOrDefault("Type", null)
//            );
//
//            plantRepository.save(plant);
//        }
//    }
//
//
//
//    public List<Plant> getAllPlants() {
//        return (List<Plant>) plantRepository.findAll();
//    }
//}



//    public void fetchAndStorePlants() {
//        String url = config.getApiUrl() + "/plants";
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("x-permapeople-key-id", config.getApiKeyId());
//        headers.set("x-permapeople-key-secret", config.getApiKeySecret());
//
//        HttpEntity<String> entity = new HttpEntity<>(headers);
//        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, entity, Map.class);
//
//        List<Map<String, Object>> plantList = (List<Map<String, Object>>) response.getBody().get("plants");
//
//        for (Map<String, Object> plantData : plantList) {
//            Integer id = (Integer) plantData.get("id");
//            String commonName = (String) plantData.get("name");
//            String slug = (String) plantData.get("slug");
//
//            // Extract Image URL
//            Map<String, String> images = (Map<String, String>) plantData.get("images");
//            String imageUrl = (images != null) ? images.get("title") : null;
//
//            // Extract additional attributes from "data"
//            List<Map<String, String>> dataList = (List<Map<String, String>>) plantData.get("data");
//            Map<String, String> dataMap = new HashMap<>();
//            for (Map<String, String> entry : dataList) {
//                dataMap.put(entry.get("key"), entry.get("value"));
//            }
//
//            Plant plant = new Plant(
//                    id,
//                    commonName,
//                    slug,
//                    imageUrl,
//                    dataMap.getOrDefault("USDA Hardiness zone", null),
//                    dataMap.getOrDefault("Life cycle", null),
//                    dataMap.getOrDefault("Light Requirement", null),
//                    dataMap.getOrDefault("Water Requirement", null),
//                    dataMap.getOrDefault("Soil Type", null),
//                    dataMap.getOrDefault("Height", null),
//                    dataMap.getOrDefault("Width", null),
//                    dataMap.getOrDefault("Layer", null),
//                    Boolean.parseBoolean(dataMap.getOrDefault("Edible", "false")),
//                    Boolean.parseBoolean(dataMap.getOrDefault("Native to", "false")),
//                    dataMap.getOrDefault("Type", null)
//            );
//
//            plantRepository.save(plant);
//        }
//    }