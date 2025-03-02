package com.damadev.native_plant.controllers;

import com.damadev.native_plant.data.PlantRepository;
import com.damadev.native_plant.models.Plant;
import com.damadev.native_plant.services.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/plants")
public class PlantController {

    private final PlantService plantService;

    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @GetMapping
    public String displayAllPlants(Model model) {
        model.addAttribute("title", "All Plants");
        model.addAttribute("plants", plantService.getAllPlants());
        return "plant-list";  // Thymeleaf template to display plants
    }

    @PostMapping("/save")
    public String savePlant(
            @RequestParam String commonName, @RequestParam String slug,
            @RequestParam String imageUrl, @RequestParam String usdaHardinessZone,
            @RequestParam String lifeCycle, @RequestParam String lightRequirement,
            @RequestParam String waterRequirement, @RequestParam String soilType,
            @RequestParam String height, @RequestParam String width,
            @RequestParam String layer, @RequestParam boolean isEdible,
            @RequestParam String nativeTo, @RequestParam String type) {

        Plant plant = new Plant(null, commonName, slug, imageUrl, usdaHardinessZone, lifeCycle,
                lightRequirement, waterRequirement, soilType, height, width,
                layer,  nativeTo, isEdible, type);

        plantService.savePlant(plant);
        return "redirect:/plants";
    }
}

//@Controller
//@RequestMapping("/plants")
//public class PlantController {
//
//    private final PlantService plantService;
//
//    @Autowired
//    public PlantController(PlantService plantService) {
//        this.plantService = plantService;
//    }
//    @PostMapping("/plants")
//    public ResponseEntity<String> addPlant(@RequestBody Plant plant) {
//        plantService.savePlant(plant);
//        return ResponseEntity.ok("Plant saved successfully!");
//    }
//
//    @PostMapping("/save")
//    public String savePlant(
//            @RequestParam String commonName, @RequestParam String slug,
//            @RequestParam String imageUrl, @RequestParam String usdaHardinessZone,
//            @RequestParam String lifeCycle, @RequestParam String lightRequirement,
//            @RequestParam String waterRequirement, @RequestParam String soilType,
//            @RequestParam String height, @RequestParam String width,
//            @RequestParam String layer, @RequestParam String isEdible,
//            @RequestParam String isNativeTo,
//            @RequestParam String type) {
//
//        Plant plant = new Plant(null, commonName, slug, imageUrl, usdaHardinessZone, lifeCycle,
//                lightRequirement, waterRequirement, soilType, height, width,
//                layer, isEdible, isNativeTo, type);
//
//        plantService.savePlant(plant);
//        return "redirect:/plants";
//    }
//}
//@Controller
//@RequestMapping("/plants")
//public class PlantController {
//
//    private final PlantService plantService;
//
//    public PlantController(PlantService plantService) {
//        this.plantService = plantService;
//    }
//
//    @GetMapping
//    public String displayAllPlants(Model model) {
//        model.addAttribute("title", "All Plants");
//        model.addAttribute("plants", plantService.getAllPlants());
//        return "plant-list";  // Thymeleaf template to display plants
//    }
//
//    @PostMapping("/save")
//    public String savePlant(
//            @RequestParam String commonName, @RequestParam String slug,
//            @RequestParam String imageUrl, @RequestParam String usdaHardinessZone,
//            @RequestParam String lifeCycle, @RequestParam String lightRequirement,
//            @RequestParam String waterRequirement, @RequestParam String soilType,
//            @RequestParam String height, @RequestParam String width,
//            @RequestParam String layer, @RequestParam boolean isEdible,
//            @RequestParam boolean isNativeTo, @RequestParam String type) {
//
//        Plant plant = new Plant(null, commonName, slug, imageUrl, usdaHardinessZone, lifeCycle,
//                lightRequirement, waterRequirement, soilType, height, width,
//                layer, isEdible, isNativeTo, type);
//
//        plantService.savePlant(plant);
//        return "redirect:/plants";
//    }
//}
