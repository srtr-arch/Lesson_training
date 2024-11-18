package com.example.bookmanagementsample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookmanagementsample.model.Genre;
import com.example.bookmanagementsample.repository.Genrerepository;

@Service
public class GenreService {
    @Autowired
    private Genrerepository genrerepository;

    public List<Genre> findAllGenres(){
        return genrerepository.findAll();
    }
    public Genre saveGenre(Genre genre){
        return genrerepository.save(genre);
    }
}
