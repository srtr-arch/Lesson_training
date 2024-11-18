package com.example.fukushu3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fukushu3.model.Shop;
import com.example.fukushu3.repository.ShopRepository;

@Service
public class ShopService {
    @Autowired
    private ShopRepository shopRepository;

    public List<Shop> findAllShops(){
        return shopRepository.findAll();
    }

    public Shop saveShop(Shop shop){
        return shopRepository.save(shop);
    }

    public Optional<Shop> findShopById(Long id){
        return shopRepository.findById(id);
    }

    public List<Shop> findShopsByName(String name){
        return shopRepository.findByName(name);
    }
}
