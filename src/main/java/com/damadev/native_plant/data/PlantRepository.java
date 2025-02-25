package com.damadev.native_plant.data;

import com.damadev.native_plant.models.Plant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantRepository extends CrudRepository<Plant, Integer> {
}
