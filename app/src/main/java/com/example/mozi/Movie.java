package com.example.mozi;

public class Movie {
    private String title;
    private String description;
    private int price; // in HUF

    public Movie(String title, String description, int price) {
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }
}
