package com.damadev.native_plant.controllers.api;

import com.damadev.native_plant.models.Plant;
import com.damadev.native_plant.services.PlantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


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

//    @PostMapping("/fetch")
//    public String fetchAndStorePlants() {
//        plantService.fetchAndStorePlants();
//        return "Plants fetched and stored successfully.";
//    }

    @PostMapping("/fetch")
    public String fetchAndStorePlants(@RequestParam(defaultValue = "5") int limit) {
        plantService.fetchAndStorePlants(limit);
        return "Fetched " + limit + " plants successfully.";
    }
}
//@RestController
//@RequestMapping("/api/plants")
//public class ApiPlantController {
//
//    private final PlantService plantService;
//
//    public ApiPlantController(PlantService plantService) {
//        this.plantService = plantService;
//    }
//
//    @GetMapping("/all")
//    public List<Plant> getAllPlants() {
//        return plantService.getAllPlants();
//    }
//    @PostMapping("/fetch")
//    public String fetchAndStorePlants(@RequestParam(defaultValue = "15") int limit) {
//        plantService.fetchAndStorePlants(limit);
//        return "Fetched " + limit + " plants successfully.";
//    }
//
//}


//    @PostMapping("/fetch")
//    public String fetchAndStorePlants() {
//        plantService.fetchAndStorePlants();
//        return "Plants fetched and stored successfully.";
//    }