package com.damadev.native_plant.models;

import jakarta.persistence.*;

import java.util.Map;

@Entity
public class Plant {

    @Id
    @GeneratedValue
//    (strategy = GenerationType.IDENTITY)
    //    fields in the json
    private Integer id;
    private String name;
    private String slug;
    private String description;
    private String scientificName;
    private String imageUrl;
//    the following is stored as a dataset in the json
//    for the key/value pair in the dataset, @ElementCollection tells Hibernate that data is a collection of values (not a separate entity)
    @ElementCollection
//    it creates a new table in MySql called plant_data and uses a Foreign key plant_id to connect them
    @CollectionTable(name = "plant_data", joinColumns = @JoinColumn(name = "plant_id"))
//    makes sure the key data is stored under data_key in MySql
    @MapKeyColumn(name = "data_key")
    //    makes sure the value data is stored under data_value in MySql
    @Column(name = "data_value")
    private Map<String, String> data;

    //Constructors

    public Plant() {}

    public Plant(String name, String slug, Map<String, String> data, String description, String scientificName, String imageUrl) {
        this.name = name;
        this.slug = slug;
        this.data = data;
        this.description = description;
        this.scientificName = scientificName;
        this.imageUrl = imageUrl;
    }

    public Plant(Integer id, String name, String slug, String description, String scientificName, String imageUrl, Map<String, String> data) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.description = description;
        this.scientificName = scientificName;
        this.imageUrl = imageUrl;
        this.data = data;
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
