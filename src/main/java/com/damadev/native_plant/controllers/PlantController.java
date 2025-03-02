package com.damadev.native_plant.controllers;

import com.damadev.native_plant.models.Plant;
import com.damadev.native_plant.services.PlantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

