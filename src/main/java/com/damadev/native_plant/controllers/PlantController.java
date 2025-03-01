package com.damadev.native_plant.controllers;

import com.damadev.native_plant.data.PlantRepository;
import com.damadev.native_plant.models.Plant;
import com.damadev.native_plant.services.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


@Controller
@RequestMapping("/plants")
public class PlantController {

    @Autowired
    private PlantRepository plantRepository;

    @Autowired
    private PlantService plantService;

    public PlantController(PlantRepository plantRepository, PlantService plantService) {
        this.plantRepository = plantRepository;
        this.plantService = plantService;
    }

    @GetMapping
    public String displayAllPlants(Model model) {
        model.addAttribute("title", "All Plants");
        model.addAttribute("plants", plantService.getStoredPlants()); // Load from repository
        return "plant-list";
    }

    // Add a new method to handle fetching and saving plants
    @PostMapping("/fetch-save")
    public String fetchAndSavePlants() {
        plantService.fetchAndSavePlants(); // Fetch and save plant data
        return "redirect:/plants"; // Redirect to the list of plants after saving
    }

}
