// package com.example.kadai1.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// import com.example.kadai1.model.User;

// @Repository
// public interface UserRepository extends JpaRepository<User,Long> {
    
// }
package com.example.kadai1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.kadai1.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}