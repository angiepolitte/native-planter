package com.damadev.native_plant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.damadev.native_plant.data") // Ensure repositories are scanned
@EntityScan("com.damadev.native_plant.models")
public class NativePlantApplication {

	public static void main(String[] args) {
		SpringApplication.run(NativePlantApplication.class, args);
	}

}
