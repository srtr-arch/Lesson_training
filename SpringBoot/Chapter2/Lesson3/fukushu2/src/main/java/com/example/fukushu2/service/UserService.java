package com.example.fukushu2.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fukushu2.model.TalkRoom;
import com.example.fukushu2.model.User;
import com.example.fukushu2.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }
    public User saveUser(User user){
        return userRepository.save(user);
    }
    public Optional<User> findUserById(Long id){
        return userRepository.findById(id);
    }
    public void saveUserWithTalkRoom(User user,Set<TalkRoom>talkRooms){
        user.setTalkrooms(talkRooms);
        userRepository.save(user);
    }
}
