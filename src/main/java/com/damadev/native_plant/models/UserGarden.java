package com.damadev.native_plant.models;

import jakarta.persistence.*;


@Entity
public class UserGarden {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "plant_id")
    private Plant plant;

    private String userEmail; // To track which user saved it

    public UserGarden() {}

    public UserGarden(Plant plant, String userEmail) {
        this.plant = plant;
        this.userEmail = userEmail;
    }

    public Integer getId() { return id; }
    public Plant getPlant() { return plant; }
    public String getUserEmail() { return userEmail; }
}

