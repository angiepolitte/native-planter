package com.damadev.native_plant.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
@Entity
public class Plant {


    @Id
    @GeneratedValue
    private int id;
    private String commonName;
    private String scientificName;
    private String cycle;
    private String watering;
    private String hardinessMin;
    private String hardinessMax;
    private boolean isEdible;

    public Plant() {};

    public Plant(int id, String commonName, String scientificName, String cycle, String watering, String hardinessMin, String hardinessMax, boolean isEdible) {
        this.id = id;
        this.commonName = commonName;
        this.scientificName = scientificName;
        this.cycle = cycle;
        this.watering = watering;
        this.hardinessMin = hardinessMin;
        this.hardinessMax = hardinessMax;
        this.isEdible = isEdible;
    }

    public int getId() {
        return id;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public String getWatering() {
        return watering;
    }

    public void setWatering(String watering) {
        this.watering = watering;
    }

    public String getHardinessMin() {
        return hardinessMin;
    }

    public void setHardinessMin(String hardinessMin) {
        this.hardinessMin = hardinessMin;
    }

    public String getHardinessMax() {
        return hardinessMax;
    }

    public void setHardinessMax(String hardinessMax) {
        this.hardinessMax = hardinessMax;
    }

    public boolean isEdible() {
        return isEdible;
    }

    public void setEdible(boolean edible) {
        isEdible = edible;
    }
}
