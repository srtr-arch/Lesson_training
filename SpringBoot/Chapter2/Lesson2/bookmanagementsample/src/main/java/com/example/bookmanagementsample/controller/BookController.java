package com.example.bookmanagementsample.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.bookmanagementsample.model.Book;
import com.example.bookmanagementsample.service.BookService;
import com.example.bookmanagementsample.service.GenreService;

import jakarta.persistence.EntityNotFoundException;

@Controller
@RequestMapping("/books")

public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private GenreService genreService;

    @GetMapping("")
    public String listBook(Model model){
        List<Book>books = bookService.findAllBooks();
        model.addAttribute("books", books);
        return "books/list";
    }
    @GetMapping("/add")
    public String addBookForm(Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("genres", genreService.findAllGenres());
        return "books/add-book";

    }
    @PostMapping("/add")
    
    public String addBook(Book book){
        System.out.println("Title: " + book.getTitle());
    System.out.println("Author: " + book.getAuthor());
    System.out.println("ISBN: " + book.getIsbn());
    System.out.println("Published Date: " + book.getPublishedDate());
    bookService.saveBook(book);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable("id")Long id,Model model){
    // Optional<Book>optionalBook = bookService.findBookById(id);
    // if(optionalBook.isPresent()){
    //     Book book = optionalBook.get();
    Book book = bookService.findBookById(id).orElseThrow(
        ()->new EntityNotFoundException("Book not found with id:"+id)
    );
    model.addAttribute("book",book);
        return "books/edit";
    // }else{

    // }
    // return "redirect://books";
    // Book book = new Book();
    //  book.setId(id);
    //  book.setTitle("javaの本");
    // book.setAuthor("SLスタジオ");
    //  book.setIsbn("1234567891011");
    //  book.setPublishedDate(LocalDate.now());

    //  model.addAttribute("book",book);
    // return "books/edit";
    }
    @PostMapping("/edit")
    public String editBook(Book book){
        bookService.updateBook(book);
        return "redirect:/books";
    }
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id")Long id){
        bookService.deleteBookById(id);
        return "redirect:/books";
    }
    @GetMapping("/search")
    public String search(
        @RequestParam(name="author",required=false)String author,Model model){
            List<Book>books = bookService.findByAuthor(author);
            model.addAttribute("books",books);
            return "/books/search";
        }
    
}
