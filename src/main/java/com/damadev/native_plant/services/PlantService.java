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
import java.util.List;

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
        String apiUrl = config.getApiUrl() + "/plants";

        HttpHeaders headers = new HttpHeaders();
        headers.set("x-permapeople-key-id", config.getApiKeyId());
        headers.set("x-permapeople-key-secret", config.getApiKeySecret());
        ResponseEntity<PlantResponseDTO> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                new HttpEntity<>(headers),
                PlantResponseDTO.class
        );

        System.out.println("API Response: " + response.getBody());

        List<PlantResponseDTO.PlantData> plantDataList = response.getBody().getPlants();

        for (PlantResponseDTO.PlantData plantData : plantDataList) {
            // Create new Plant entity
            Plant plant = new Plant();
            plant.setCommonName(plantData.getName());
            plant.setSlug(plantData.getSlug());
            plant.setType(plantData.getType() != null ? plantData.getType() : "Unknown");


            // Extract specific values from 'data' array
            plant.setUsdaHardinessZone(extractAttributeValue(plantData.getData(), "USDA Hardiness zone"));
            plant.setLifeCycle(extractAttributeValue(plantData.getData(), "Life cycle"));
            plant.setLightRequirement(extractAttributeValue(plantData.getData(), "Light requirement"));
            plant.setWaterRequirement(extractAttributeValue(plantData.getData(), "Water requirement"));
            plant.setSoilType(extractAttributeValue(plantData.getData(), "Soil type"));
            plant.setHeight(extractAttributeValue(plantData.getData(), "Height"));
            plant.setWidth(extractAttributeValue(plantData.getData(), "Width"));
            plant.setLayer(extractAttributeValue(plantData.getData(), "Layer"));
            plant.setType(extractAttributeValue(plantData.getData(), "Type"));

            // Set image URL
//            plant.setImageUrl(plantData.getImages() != null ? plantData.getImages().getTitle() : "default_image_url");
            plant.setImageUrl(plantData.getImages() != null ? plantData.getImages().get("title") : "default_image_url");

            // Set 'nativeTo'
            plant.setNativeTo(extractAttributeValue(plantData.getData(), "Native to"));
            // Set 'isEdible' by extracting the boolean value (if exists)
            plant.setEdible(extractBooleanAttributeValue(plantData.getData(), "Edible"));

            // Store the plant
            plantRepository.save(plant);
        }
    }

    public List<Plant> getAllPlants() {
        Iterable<Plant> plants = plantRepository.findAll();
        List<Plant> plantList = new ArrayList<>();
        plants.forEach(plantList::add);  // Adds each plant to the list
        return plantList;
    }

    private String extractAttributeValue(List<PlantResponseDTO.PlantAttribute> attributes, String key) {
        if (attributes == null) {
            return null;  // Return null if attributes is null
        }

        return attributes.stream()
                .filter(attr -> key.equals(attr.getKey()))
                .map(PlantResponseDTO.PlantAttribute::getValue)
                .findFirst()
                .orElse(null);
    }

    private boolean extractBooleanAttributeValue(List<PlantResponseDTO.PlantAttribute> attributes, String key) {
        String value = extractAttributeValue(attributes, key);
        return value != null && "true".equalsIgnoreCase(value);
    }
}

//        HttpEntity<String> entity = new HttpEntity<>(headers);
//        ResponseEntity<PlantResponseDTO> response = restTemplate.exchange(url, HttpMethod.GET, entity, PlantResponseDTO.class);
//
//        List<PlantResponseDTO.PlantData> plantList = response.getBody().getPlants();
//        int count = 0;
//
//        for (PlantResponseDTO.PlantData plantData : plantList) {
//            if (count >= limit) break;  // Stop after fetching the specified limit
//            count++;
//
//            System.out.println("Fetched Plant: " + plantData.getName() + ", " + plantData.getSlug() + ", " + plantData.getImageUrl());
//
//            // Map the plant data to the Plant model
//            Plant plant = new Plant(
//                    null,
//                    plantData.getName(),
//                    plantData.getSlug(),
//                    plantData.getImageUrl(),  // No need for the manual extraction of the image URL
//                    plantData.getUsdaHardinessZone(),
//                    plantData.getLifeCycle(),
//                    plantData.getLightRequirement(),
//                    plantData.getWaterRequirement(),
//                    plantData.getSoilType(),
//                    plantData.getHeight(),
//                    plantData.getWidth(),
//                    plantData.getLayer(),
//                    plantData.getNativeTo(),  // NativeTo from the attributes
//                    plantData.isEdible(),  // Edible from the attributes
//                    plantData.getType()  // Type from the attributes
//            );
//
//            plantRepository.save(plant);
//        }
//    }
//    public List<Plant> getAllPlants() {
//        return (List<Plant>) plantRepository.findAll();
//    }
//}
//
//    // Helper method to find values in the "data" array
//    private String findValue(List<PlantResponseDTO.PlantAttribute> data, String key) {
//        for (PlantResponseDTO.PlantAttribute entry : data) {
//            if (entry.getKey().equalsIgnoreCase(key)) {
//                return entry.getValue();
//            }
//        }
//        return null; // Return null if key is not found
//    }
//        List<PlantResponseDTO.PlantData> plantList = response.getBody().getPlants();
//        int count = 0;
//
//        for (PlantResponseDTO.PlantData plantData : plantList) {
//            if (count >= limit) break;  // Stop after fetching the specified limit
//            count++;
//
//            // Map the plant data to the Plant model
//            Plant plant = new Plant(
//                    null,
//                    plantData.getName(),
//                    plantData.getSlug(),
//                    plantData.getImageUrl(),
//                    plantData.getUsdaHardinessZone(),
//                    plantData.getLifeCycle(),
//                    plantData.getLightRequirement(),
//                    plantData.getWaterRequirement(),
//                    plantData.getSoilType(),
//                    plantData.getHeight(),
//                    plantData.getWidth(),
//                    plantData.getLayer(),
//                    plantData.getNativeTo(),  // Directly use nativeTo as String
//                    plantData.isEdible(),  // Use boolean directly
//                    plantData.getType()
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
