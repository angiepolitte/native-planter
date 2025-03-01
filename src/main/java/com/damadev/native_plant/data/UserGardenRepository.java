package com.damadev.native_plant.data;


import com.damadev.native_plant.models.UserGarden;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserGardenRepository extends CrudRepository<UserGarden, Integer> {
    List<UserGarden> findByUserEmail(String userEmail);
}
