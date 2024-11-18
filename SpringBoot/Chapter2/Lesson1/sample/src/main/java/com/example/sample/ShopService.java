package com.example.sample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.ShopRepository;

@Service
public class ShopService {
    @Autowired
    private ShopRepository shopRepository;

    public List<Shop>findAllShops(){
        List<Shop>shops = shopRepository.findAll();
        return shops;
    }
    public Shop saveShop(Shop shop){
    return    shopRepository.save(shop);
    }
}
