package com.example.fukushu1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fukushu1.model.Book;
import com.example.fukushu1.repository.BookRepository;

@Service
public class BookService  {
    @Autowired
    private BookRepository bookRepository;
    public List<Book> findAllBooks(){
        List<Book>books = bookRepository.findAll();
        return books;
    }
    public Book saveBook(Book book){
        return bookRepository.save(book);
    }
}

