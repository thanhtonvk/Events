package com.example.events.models;

public class Place {
    private String id;
    private String name;
    private int minCost;
    private int maxCost;
    private String eventType;
    private int quantity;
    private String convenient;
    private String other;
    private String image;
    private String area;

    public Place(String id, String name, int minCost, int maxCost, String eventType, int quantity, String convenient, String other, String image, String area) {
        this.id = id;
        this.name = name;
        this.minCost = minCost;
        this.maxCost = maxCost;
        this.eventType = eventType;
        this.quantity = quantity;
        this.convenient = convenient;
        this.other = other;
        this.image = image;
        this.area = area;
    }

    public Place() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinCost() {
        return minCost;
    }

    public void setMinCost(int minCost) {
        this.minCost = minCost;
    }

    public int getMaxCost() {
        return maxCost;
    }

    public void setMaxCost(int maxCost) {
        this.maxCost = maxCost;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getConvenient() {
        return convenient;
    }

    public void setConvenient(String convenient) {
        this.convenient = convenient;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
