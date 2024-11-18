package com.example.bookmanagementsample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookmanagementsample.model.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store,Long>{
    
}
