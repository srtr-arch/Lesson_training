package com.example.fukushu1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fukushu1.model.User;
import com.example.fukushu1.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUsers(){
        List<User>users = userRepository.findAll();
        return users;
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }
    
}
