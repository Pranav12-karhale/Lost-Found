package com.LnF.lostandfound.model;

import java.sql.Date;

public class SearchResult {
    private String type;
    private String itemName;
    private String category;
    private String description;
    private String location;
    private Date date;
    private String imagePath;

    public SearchResult(String type, String itemName, String category, String description, String location, Date date,
            String imagePath) {
        this.type = type;
        this.itemName = itemName;
        this.category = category;
        this.description = description;
        this.location = location;
        this.date = date;
        this.imagePath = imagePath;
    }

    // getters
    public String getType() {
        return type;
    }

    public String getItemName() {
        return itemName;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public Date getDate() {
        return date;
    }

    public String getImagePath() {
        return imagePath;
    }
}