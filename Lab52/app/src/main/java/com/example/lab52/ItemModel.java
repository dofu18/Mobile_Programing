package com.example.lab52;

public class ItemModel {
    private int image;
    private String title;
    private String description;
    private String platform;

    public ItemModel(int image, String title, String description, String platform) {
        this.image = image;
        this.title = title;
        this.description = description;
        this.platform = platform;
    }

    public int getImage() { return image; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getPlatform() { return platform; }

    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
}

