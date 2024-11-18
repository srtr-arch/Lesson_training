package com.example.fukushu3.model;

import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@SQLRestriction("is_deleted = false")
@Table(name="shops")
public class Shop {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable=false)
    private String name;
    @Column(nullable=false)
    private String address;
    @Column(nullable=false)
    private String details;
    @Column(nullable=false)
    private boolean isDeleted;
    public Shop() {
    }
    public Shop(Long id, String name, String address, String details, boolean isDeleted) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.details = details;
        this.isDeleted = isDeleted;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getDetails() {
        return details;
    }
    public void setDetails(String details) {
        this.details = details;
    }
    public boolean isDeleted() {
        return isDeleted;
    }
    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    
    
}
