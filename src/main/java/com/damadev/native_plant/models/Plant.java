package com.damadev.native_plant.models;

import jakarta.persistence.*;

import java.util.Map;

@Entity
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String slug;

    @ElementCollection
    @CollectionTable(name = "plant_data", joinColumns = @JoinColumn(name = "plant_id"))
    @MapKeyColumn(name = "data_key")
    @Column(name = "data_value")
    private Map<String, String> data;

    private String description;
    private String scientificName;
    private String imageUrl;

    public Plant() {}

    public Plant(String name, String slug, Map<String, String> data, String description, String scientificName, String imageUrl) {
        this.name = name;
        this.slug = slug;
        this.data = data;
        this.description = description;
        this.scientificName = scientificName;
        this.imageUrl = imageUrl;
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

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
