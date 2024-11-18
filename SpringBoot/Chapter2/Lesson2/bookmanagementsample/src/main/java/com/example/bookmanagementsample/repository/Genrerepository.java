package com.example.bookmanagementsample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookmanagementsample.model.Genre;

@Repository
public interface Genrerepository extends JpaRepository<Genre,Long>{
    
}
