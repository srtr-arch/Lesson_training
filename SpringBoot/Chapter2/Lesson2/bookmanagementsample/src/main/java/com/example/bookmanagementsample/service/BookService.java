package com.example.bookmanagementsample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookmanagementsample.model.Book;
import com.example.bookmanagementsample.repository.BookRepository;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAllBooks(){
        return bookRepository.findAll();
    }

    public Optional<Book> findBookById(Long id){
        return bookRepository.findById(id);
    }

    public List<Book>findByAuthor(String author){
        return bookRepository.findByAuthorSQL(author);
    }

    public Book updateBook(Book updatedBook){
        return bookRepository.save(updatedBook);
    }

    public void deleteBookById(Long id){

        Optional<Book>optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()){
            Book book = optionalBook.get();
            book.setDeleted(true);
            bookRepository.save(book);
        }
        // bookRepository.deleteById(id);
    }
    public Book saveBook(Book book){
        return bookRepository.save(book);
    }
}
