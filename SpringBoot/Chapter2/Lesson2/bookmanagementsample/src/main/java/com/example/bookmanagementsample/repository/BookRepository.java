package com.example.bookmanagementsample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.bookmanagementsample.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Long>{
    List<Book>findByAuthor(String name);

    @Query(value = "SELECT* FROM books WHERE author = :author",nativeQuery = true)
    List<Book>findByAuthorSQL(@Param("author")String name);
}
