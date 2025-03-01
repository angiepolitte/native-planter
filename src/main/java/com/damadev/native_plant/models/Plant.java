package com.damadev.native_plant.models;

import jakarta.persistence.*;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Entity
@Table(name= "plants")
public class Plant {

    @Id
    @GeneratedValue
//    (strategy = GenerationType.IDENTITY)
    //    fields in the json
    private Integer id;
    private String name;
    private String slug;
    private String imageUrl;
    private String usdaHardinessZone;
    private String lifeCycle;
    private String lightRequirement;
    private String waterRequirement;
    private String soilType;
    private String height;
    private String width;
    private String layer;
    private boolean isEdible;
    private boolean isNativeTo;
    private String type;


    //Constructors

    public Plant() {}

    public Plant(Integer id, String name, String slug, String imageUrl, String usdaHardinessZone, String lifeCycle, String lightRequirement, String waterRequirement, String soilType, String height, String width, String layer, boolean isEdible, boolean isNativeTo, String type) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.imageUrl = imageUrl;
        this.usdaHardinessZone = usdaHardinessZone;
        this.lifeCycle = lifeCycle;
        this.lightRequirement = lightRequirement;
        this.waterRequirement = waterRequirement;
        this.soilType = soilType;
        this.height = height;
        this.width = width;
        this.layer = layer;
        this.isEdible = isEdible;
        this.isNativeTo = isNativeTo;
        this.type = type;
//        this.data = data;
    }

    // Getters and Setters


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUsdaHardinessZone() {
        return usdaHardinessZone;
    }

    public void setUsdaHardinessZone(String usdaHardinessZone) {
        this.usdaHardinessZone = usdaHardinessZone;
    }

    public String getLifeCycle() {
        return lifeCycle;
    }

    public void setLifeCycle(String lifeCycle) {
        this.lifeCycle = lifeCycle;
    }

    public String getLightRequirement() {
        return lightRequirement;
    }

    public void setLightRequirement(String lightRequirement) {
        this.lightRequirement = lightRequirement;
    }

    public String getWaterRequirement() {
        return waterRequirement;
    }

    public void setWaterRequirement(String waterRequirement) {
        this.waterRequirement = waterRequirement;
    }

    public String getSoilType() {
        return soilType;
    }

    public void setSoilType(String soilType) {
        this.soilType = soilType;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getLayer() {
        return layer;
    }

    public void setLayer(String layer) {
        this.layer = layer;
    }

    public boolean isEdible() {
        return isEdible;
    }

    public void setEdible(boolean edible) {
        isEdible = edible;
    }

    public boolean isNativeTo() {
        return isNativeTo;
    }

    public void setNativeTo(boolean nativeTo) {
        isNativeTo = nativeTo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

//    public Map<String, String> getData() {
//        return data;
//    }
//
//    public void setData(Map<String, String> data) {
//        this.data = data;
//    }
}
