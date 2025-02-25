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

    @GetMapping
    public String displayAllPlants(Model model) {
        model.addAttribute("title", "All Plants");
        model.addAttribute("plants", plantService.getAllPlants()); // Load API data
        return "plant-list";
    }

    @PostMapping("/save")
    public String savePlant(@RequestParam String name, @RequestParam String slug,
                            @RequestParam String description, @RequestParam String scientificName,
                            @RequestParam String imageUrl, @RequestParam Map<String, String> data) {

        // Remove form-specific fields from the data map
        data.remove("name");
        data.remove("slug");
        data.remove("description");
        data.remove("scientificName");
        data.remove("imageUrl");

        Plant plant = new Plant(name, slug, data, description, scientificName, imageUrl);
        plantRepository.save(plant);
        return "redirect:/plants"; // Reload page
    }

}
