package com.damadev.native_plant.controllers;

import com.damadev.native_plant.data.PlantRepository;
import com.damadev.native_plant.data.UserGardenRepository;
import com.damadev.native_plant.models.Plant;
import com.damadev.native_plant.models.UserGarden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/garden")
public class GardenController {

    private final UserGardenRepository userGardenRepository;
    private final PlantRepository plantRepository;

    @Autowired
    public GardenController(UserGardenRepository userGardenRepository, PlantRepository plantRepository) {
        this.userGardenRepository = userGardenRepository;
        this.plantRepository = plantRepository;
    }

    @PostMapping("/save")
    public String savePlantToGarden(@RequestParam Integer plantId) {
        Plant plant = plantRepository.findById(plantId).orElse(null);
        if (plant != null) {
            UserGarden gardenPlant = new UserGarden(plant, "test@example.com"); // Replace with logged-in user
            userGardenRepository.save(gardenPlant);
        }
        return "redirect:/plants";
    }
}
