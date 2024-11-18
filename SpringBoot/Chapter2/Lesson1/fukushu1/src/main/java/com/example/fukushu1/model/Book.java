package com.example.fukushu1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="books")
public class Book {
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

private Long id;

@Column(nullable=false)
private String title;

@Column(nullable=false)
private String author;

@Column
private Long price;

public Book() {
}

public Book(Long id, String title, String author, Long price) {
    this.id = id;
    this.title = title;
    this.author = author;
    this.price = price;
}

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getTitle() {
    return title;
}

public void setTitle(String title) {
    this.title = title;
}

public String getAuthor() {
    return author;
}

public void setAuthor(String author) {
    this.author = author;
}

public Long getPrice() {
    return price;
}

public void setPrice(Long price) {
    this.price = price;
}




    
}
