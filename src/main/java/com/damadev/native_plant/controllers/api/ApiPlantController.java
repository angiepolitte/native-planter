package com.damadev.native_plant.controllers.api;

import com.damadev.native_plant.controllers.services.PlantApiService;
import com.damadev.native_plant.data.PlantRepository;
import com.damadev.native_plant.models.Plant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/plants")
public class ApiPlantController {

    @Autowired
    private PlantRepository plantRepository;

    @Autowired
    private PlantApiService plantApiService;

    @GetMapping
    public ResponseEntity<List<Plant>> getPlants() {
        List<Plant> plants = plantApiService.fetchPlants();
        return ResponseEntity.ok(plants); //Returns JSON instead of HTML
    }
    @GetMapping("/{id}")
    public ResponseEntity<Plant> getPlantById(@PathVariable int id) {
        System.out.println("Fetching plant with id: " + id);
        Optional<Plant> plant = plantRepository.findById(id);
        return plant.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    @PostMapping
    public ResponseEntity<Plant> createPlant(@RequestBody Plant plant) {
        Plant savedPlant = plantRepository.save(plant); // Save plant in DB
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPlant);
    }
}
















//
//
//public class ApiPlantController {
//
//    private final PlantRepository plantRepository;
//    private final PlantApiService plantApiService;
//
//    @Autowired
//    public ApiPlantController(PlantRepository plantRepository, PlantApiService plantApiService) {
//        this.plantRepository = plantRepository;
//        this.plantApiService = plantApiService;
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Plant> getPlantById(@PathVariable int id) {
//        System.out.println("Fetching plant with id: " + id);
//        return plantRepository.findById(id)
//                .map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
//    }
//}
//


















































//
//@RestController
//@RequestMapping("/api/plants")
//public class ApiPlantController {
//
//
//    @Autowired
//    private PlantRepository plantRepository;
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//    //    https://perenual.com/docs/api
//    // key sk-vnyO67ba08a1348818792
//    @Value("${perenual.api.key}")
//    private String apiKey;
//
//
////    Endpoint to fetch all plants from database
//    @GetMapping
//    public ResponseEntity<?> getAllPlants() {
//        List<Plant> plants = (List<Plant>) plantRepository.findAll();
//        return new ResponseEntity<>(plants, HttpStatus.OK);
//    }
//
////    Endpoint to fetch plant by ID from database
//    @GetMapping("/{id}")
//    public ResponseEntity<?> getPlantsById(@PathVariable Integer id) {
//
//        Optional<Plant> plantOptional = plantRepository.findById(id);
//        if (plantOptional.isPresent()) {
//            return new ResponseEntity<>(plantOptional.get(), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
////    Calling the external API
//    @GetMapping("/external")
//    public ResponseEntity<?> getExternalPlants() {
//        String url = "https://perenual.com/api/plants?key=" + apiKey;
//        String response = restTemplate.getForObject(url, String.class);
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//}
//
//
//
////    package com.damadev.native_plant.controllers.configurations;
////
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
////
////    @Configuration
////    public class AppConfig {
////        @Bean
////        public RestTemplate restTemplate() {
////            return new RestTemplate();
////        }
////    }
//
//
//
//
