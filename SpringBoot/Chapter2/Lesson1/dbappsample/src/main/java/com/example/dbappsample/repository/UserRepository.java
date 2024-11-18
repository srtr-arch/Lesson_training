package com.example.dbappsample.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dbappsample.model.User;

@Repository
public interface  UserRepository extends JpaRepository<User,Long>{
    
}
