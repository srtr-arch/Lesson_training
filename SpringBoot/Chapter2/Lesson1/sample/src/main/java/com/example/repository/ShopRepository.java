package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sample.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop,Long>{
    
}
