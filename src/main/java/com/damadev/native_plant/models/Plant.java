package com.damadev.native_plant.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
public class Plant {

    @Id
    @GeneratedValue
    private Integer id;


    private String commonName;
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
    @Size(max = 1000)
    private String nativeTo;
    private boolean isEdible;


    private String type;

    public Plant() {}

    public Plant(Integer id, String commonName, String slug, String imageUrl, String usdaHardinessZone, String lifeCycle, String lightRequirement, String waterRequirement, String soilType, String height, String width, String layer, String nativeTo, boolean isEdible, String type) {
        this.id = id;
        this.commonName = commonName;
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
        this.nativeTo = nativeTo;
        this.isEdible = isEdible;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
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

    public String getNativeTo() {
        return nativeTo;
    }

    public void setNativeTo(String nativeTo) {
        this.nativeTo = nativeTo;
    }

    public boolean isEdible() {
        return isEdible;
    }

    public void setEdible(boolean isEdible) {
        isEdible = isEdible;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
//@Entity
//public class Plant {
//
//    @Id
//    private Integer id;
//
//    private String commonName;
//    private String slug;
//    private String imageUrl;
//    private String usdaHardinessZone;
//    private String lifeCycle;
//    private String lightRequirement;
//    private String waterRequirement;
//    private String soilType;
//    private String height;
//    private String width;
//    private String layer;
//
//    private boolean isEdible;
//    private boolean isNativeTo;
//
//    private String type;
//
//    public Plant() {}
//
//    public Plant(Integer id, String commonName, String slug, String imageUrl,
//                 String usdaHardinessZone, String lifeCycle, String lightRequirement,
//                 String waterRequirement, String soilType, String height, String width,
//                 String layer, boolean isEdible, boolean isNativeTo, String type) {
//        this.id = id;
//        this.commonName = commonName;
//        this.slug = slug;
//        this.imageUrl = imageUrl;
//        this.usdaHardinessZone = usdaHardinessZone;
//        this.lifeCycle = lifeCycle;
//        this.lightRequirement = lightRequirement;
//        this.waterRequirement = waterRequirement;
//        this.soilType = soilType;
//        this.height = height;
//        this.width = width;
//        this.layer = layer;
//        this.isEdible = isEdible;
//        this.isNativeTo = isNativeTo;
//        this.type = type;
//    }
//
//    // Getters and Setters (Omitted for brevity)
//
//    public Integer getId() {
//        return id;
//    }
//
//    public String getCommonName() {
//        return commonName;
//    }
//
//    public void setCommonName(String commonName) {
//        this.commonName = commonName;
//    }
//
//    public String getSlug() {
//        return slug;
//    }
//
//    public void setSlug(String slug) {
//        this.slug = slug;
//    }
//
//    public String getImageUrl() {
//        return imageUrl;
//    }
//
//    public void setImageUrl(String imageUrl) {
//        this.imageUrl = imageUrl;
//    }
//
//    public String getUsdaHardinessZone() {
//        return usdaHardinessZone;
//    }
//
//    public void setUsdaHardinessZone(String usdaHardinessZone) {
//        this.usdaHardinessZone = usdaHardinessZone;
//    }
//
//    public String getLifeCycle() {
//        return lifeCycle;
//    }
//
//    public void setLifeCycle(String lifeCycle) {
//        this.lifeCycle = lifeCycle;
//    }
//
//    public String getLightRequirement() {
//        return lightRequirement;
//    }
//
//    public void setLightRequirement(String lightRequirement) {
//        this.lightRequirement = lightRequirement;
//    }
//
//    public String getWaterRequirement() {
//        return waterRequirement;
//    }
//
//    public void setWaterRequirement(String waterRequirement) {
//        this.waterRequirement = waterRequirement;
//    }
//
//    public String getSoilType() {
//        return soilType;
//    }
//
//    public void setSoilType(String soilType) {
//        this.soilType = soilType;
//    }
//
//    public String getHeight() {
//        return height;
//    }
//
//    public void setHeight(String height) {
//        this.height = height;
//    }
//
//    public String getWidth() {
//        return width;
//    }
//
//    public void setWidth(String width) {
//        this.width = width;
//    }
//
//    public String getLayer() {
//        return layer;
//    }
//
//    public void setLayer(String layer) {
//        this.layer = layer;
//    }
//
//    public boolean isEdible() {
//        return isEdible;
//    }
//
//    public void setEdible(boolean edible) {
//        isEdible = edible;
//    }
//
//    public boolean isNativeTo() {
//        return isNativeTo;
//    }
//
//    public void setNativeTo(boolean nativeTo) {
//        isNativeTo = nativeTo;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//}