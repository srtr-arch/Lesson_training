package com.example.bookmanagementsample.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.bookmanagementsample.model.Book;
import com.example.bookmanagementsample.model.Store;
import com.example.bookmanagementsample.service.BookService;
import com.example.bookmanagementsample.service.StoreService;

import jakarta.persistence.EntityNotFoundException;

@Controller
@RequestMapping("/stores")
public class StoreController {
    @Autowired
    private StoreService storeService;
    @Autowired
    private BookService bookService;

    @GetMapping
    public String listStore(Model model) {
        List<Store> stores = storeService.findAllStores();
        model.addAttribute("stores", stores);
        return "stores/list";
    }

    @GetMapping("/add")
    public String addStoreForm(Model model) {
        model.addAttribute("store", new Store());
        model.addAttribute("book", new Book());
        return "stores/add-store";
    }

    @PostMapping("/add")
    public String addStore(Store store,@RequestParam(name="books")List<Long>books){
        Set<Book>bookSet = new HashSet<>();
        for(Long bookId : books){
            bookSet.add(new Book(bookId));
        }
        storeService.saveStoreWithBooks(store, bookSet);
        return "redirect:/stores";
    }
    @GetMapping("/edit/{id}")
    public String showEditiStoreForm(@PathVariable(name="id")Long id,Model model){
        Store store = storeService.findStoreById(id).orElseThrow(()->new EntityNotFoundException("Store not found"));
        model.addAttribute("store", store);
        model.addAttribute("allBooks", bookService.findAllBooks());
        return "stores/edit";
    }
    @PostMapping("/edit")
    public String updateStore(Store store,@RequestParam(name="books")List<Long>books){
        Set<Book>bookSet = books.stream()
        .map(bookId->new Book(bookId))
        .collect(Collectors.toSet());
        storeService.updateStoreWithBooks(store, bookSet);
        return "redirect:/stores";
    }
    @GetMapping("/delete/{id}")
    public String deleteStore(@PathVariable(name="id")Long id){
        storeService.deleteStore(id);
        return "redirect:/stores";
    }
}
