package com.example.fukushu3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.fukushu3.model.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop,Long>{
    
    @Query(value = "SELECT * FROM shops WHERE name LIKE :name", nativeQuery = true)
    public List<Shop> findByName(@Param("name") String name);
    
    
}


// @Query(value = "SELECT * FROM shops WHERE name LIKE %:name%",nativeQuery = true)
    // public List<Shop> findByName(@Param("name")String name);
