package com.example.fukushu3;

public class Product {
    private String name;
    private int price;
    public String getName() {
        return name;
    }
    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}
