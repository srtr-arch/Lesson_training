package com.example.thymeleafsample.controller;

public class Product {
    private String name;
    public double price;

    public Product(String name,double price){
        this.name=name;
        this.price= price;
    }
    public String getName(){
        return this.name;
    }
    
}
