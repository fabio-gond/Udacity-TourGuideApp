package com.example.fabio.tourguideapp;

public class Attraction {
    private String name;
    private String description;
    private String address;
    private int imgResourceId;

    public Attraction(String name, String description, String address , int imgResourceId) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.imgResourceId = imgResourceId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }

    public int getImgResourceId() {
        return imgResourceId;
    }

}
