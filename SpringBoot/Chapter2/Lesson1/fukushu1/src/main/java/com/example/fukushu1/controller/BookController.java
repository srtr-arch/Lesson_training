package com.example.fukushu1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.fukushu1.model.Book;
import com.example.fukushu1.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired 
    private BookService bookService;
    @GetMapping("")
    public String listBook(Model model){
        List<Book>books = bookService.findAllBooks();
        model.addAttribute("books", books);
        return "/books";
    }

    @GetMapping("/add")
    public String addBookForm(Model model){
        model.addAttribute("book", new Book());
        return "add-book";

    }
    @PostMapping("/add")
    public String addBook(Book book){
        System.out.println(book.getTitle());
        bookService.saveBook(book);
        return "redirect:/books/add";

    }


    

    
}
