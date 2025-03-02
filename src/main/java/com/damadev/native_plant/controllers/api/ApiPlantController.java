package com.damadev.native_plant.controllers.api;

import com.damadev.native_plant.models.Plant;
import com.damadev.native_plant.services.PlantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/plants")
public class ApiPlantController {

    private final PlantService plantService;

    public ApiPlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @GetMapping("/all")
    public List<Plant> getAllPlants() {
        return plantService.getAllPlants();
    }

    @PostMapping("/fetch")
    public ResponseEntity<List<Plant>> fetchAndStorePlants(@RequestParam(defaultValue = "5") int limit) {
        // Fetch and store plants
        plantService.fetchAndStorePlants(limit);

        // Get the list of plants to return
        List<Plant> plants = plantService.getAllPlants();

        // Return the list of fetched plants in the response body
        return ResponseEntity.ok(plants);
    }

//    @PostMapping("/fetch")
//    public String fetchAndStorePlants(@RequestParam(defaultValue = "5") int limit) {
//        plantService.fetchAndStorePlants(limit);
//        return "Fetched " + limit + " plants successfully.";
//    }
}
