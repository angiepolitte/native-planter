package com.damadev.native_plant.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PlantResponseDTO {
    @JsonProperty("plants")
    private List<PlantData> plants;

    public List<PlantData> getPlants() {
        return plants;
    }

    public static class PlantData {
        private Integer id;
        private String name;
        private String slug;

        @JsonProperty("image")
        private String imageUrl;

        @JsonProperty("data")
        private List<PlantAttribute> attributes;

        public Integer getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getSlug() {
            return slug;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public String getAttributeValue(String key) {
            return attributes.stream()
                    .filter(attr -> key.equals(attr.getKey()))
                    .map(PlantAttribute::getValue)
                    .findFirst()
                    .orElse(null);
        }

        public boolean getBooleanAttributeValue(String key) {
            return "true".equalsIgnoreCase(getAttributeValue(key));
        }

        public String getUsdaHardinessZone() {
            return getAttributeValue("USDA Hardiness zone");
        }

        public String getLifeCycle() {
            return getAttributeValue("Life cycle");
        }

        public String getLightRequirement() {
            return getAttributeValue("Light Requirement");
        }

        public String getWaterRequirement() {
            return getAttributeValue("Water Requirement");
        }

        public String getSoilType() {
            return getAttributeValue("Soil Type");
        }

        public String getHeight() {
            return getAttributeValue("Height");
        }

        public String getWidth() {
            return getAttributeValue("Width");
        }

        public String getLayer() {
            return getAttributeValue("Layer");
        }

        public boolean isEdible() {
            return getBooleanAttributeValue("Edible");
        }

        public String getNativeTo() {
            return getAttributeValue("Native to");
        }

        public String getType() {
            return getAttributeValue("Type");
        }
    }

    public static class PlantAttribute {
        private String key;
        private String value;

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
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
//        @JsonProperty("image")
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
//        public String getAttributeValue(String key) {
//            return attributes.stream()
//                    .filter(attr -> key.equals(attr.getKey()))
//                    .map(PlantAttribute::getValue)
//                    .findFirst()
//                    .orElse(null);
//        }
//
//        public boolean getBooleanAttributeValue(String key) {
//            return "true".equalsIgnoreCase(getAttributeValue(key));
//        }
//
//        public String getUsdaHardinessZone() {
//            return getAttributeValue("USDA Hardiness zone");
//        }
//
//        public String getLifeCycle() {
//            return getAttributeValue("Life cycle");
//        }
//
//        public String getLightRequirement() {
//            return getAttributeValue("Light Requirement");
//        }
//
//        public String getWaterRequirement() {
//            return getAttributeValue("Water Requirement");
//        }
//
//        public String getSoilType() {
//            return getAttributeValue("Soil Type");
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
//            return getBooleanAttributeValue("Edible");
//        }
//
//        public boolean isNativeTo() {
//            return getBooleanAttributeValue("Native to");
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
