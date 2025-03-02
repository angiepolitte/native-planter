package com.damadev.native_plant.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class PlantResponseDTO {

    private List<PlantData> plants;

    // Getters and setters for 'plants'
    public List<PlantData> getPlants() {
        return plants;
    }

    public void setPlants(List<PlantData> plants) {
        this.plants = plants;
    }

    public static class PlantData {

        private String name;
        private String slug;
        private List<PlantAttribute> data;
        private String imageUrl;            // Image URL mapping
        private String nativeTo;            // Native to mapping
        private String type;
        private Map<String, String> images; // Should be Map<String, String>

        public Map<String, String> getImages() {
            return images;
        }

        public void setImages(Map<String, String> images) {
            this.images = images;
        }

        // Getters and setters for 'name', 'slug', 'attributes', and 'imageUrl'
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

        public List<PlantAttribute> getData() {
            return data;
        }

        public void setData(List<PlantAttribute> data) {
            this.data = data;
        }

//        public String getImages() {
//            return imageUrl;
//        }
//
//        public void setImageUrl(String imageUrl) {
//            this.imageUrl = imageUrl;
//        }

        public String getNativeTo() {
            return nativeTo;
        }

        public void setNativeTo(String nativeTo) {
            this.nativeTo = nativeTo;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    public static class PlantAttribute {

        private String key;
        private String value;

        // Getters and setters for 'key' and 'value'
        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
//public class PlantResponseDTO {
//    @JsonProperty("plants")
//    private List<PlantData> plants;
//
//    public List<PlantData> getPlants() {
//        return plants;
//    }
//
//    public static class PlantData {
//        private Integer id;
//        private String name;
//        private String slug;
//
//        @JsonProperty("image_url")
//        private String imageUrl;
//
//        @JsonProperty("data")
//        private List<PlantAttribute> attributes;
//
//        public Integer getId() {
//            return id;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public String getSlug() {
//            return slug;
//        }
//
//        public String getImageUrl() {
//            return imageUrl;
//        }
//
//        // General method to get the value of any attribute by key
//        public String getAttributeValue(String key) {
//            return attributes.stream()
//                    .filter(attr -> key.equals(attr.getKey()))
//                    .map(PlantAttribute::getValue)
//                    .findFirst()
//                    .orElse(null);
//        }
//
//        // Specialized methods to extract key values directly
//        public String getUsdaHardinessZone() {
//            return getAttributeValue("USDA Hardiness zone");
//        }
//
//        public String getLifeCycle() {
//            return getAttributeValue("Life cycle");
//        }
//
//        public String getLightRequirement() {
//            return getAttributeValue("Light requirement");  // Matching key with the attribute name
//        }
//
//        public String getWaterRequirement() {
//            return getAttributeValue("Water requirement");  // Matching key with the attribute name
//        }
//
//        public String getSoilType() {
//            return getAttributeValue("Soil type");  // Matching key with the attribute name
//        }
//
//        public String getHeight() {
//            return getAttributeValue("Height");
//        }
//
//        public String getWidth() {
//            return getAttributeValue("Width");
//        }
//
//        public String getLayer() {
//            return getAttributeValue("Layer");
//        }
//
//        public boolean isEdible() {
//            return "true".equalsIgnoreCase(getAttributeValue("Edible"));
//        }
//
//        public String getNativeTo() {
//            return getAttributeValue("Native to");
//        }
//
//        public String getType() {
//            return getAttributeValue("Type");
//        }
//    }
//
//    public static class PlantAttribute {
//        private String key;
//        private String value;
//
//        public String getKey() {
//            return key;
//        }
//
//        public String getValue() {
//            return value;
//        }
//    }
//}



















