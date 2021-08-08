package com.example.instagram;

public class MainItem {
    private int id;
    private int imageId;

    public MainItem(int id, int imageId) {
        this.id = id;
        this.imageId = imageId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
