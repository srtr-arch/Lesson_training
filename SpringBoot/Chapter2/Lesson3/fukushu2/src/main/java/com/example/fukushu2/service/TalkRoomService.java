package com.example.fukushu2.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fukushu2.model.TalkRoom;
import com.example.fukushu2.model.User;
import com.example.fukushu2.repository.TalkRoomRepository;
import com.example.fukushu2.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class TalkRoomService {
    @Autowired
    private TalkRoomRepository talkRoomRepository;

    @Autowired
    private UserRepository userRepository;
    
    public List<TalkRoom> findAllTalkRooms(){
        return talkRoomRepository.findAll();
    }
    public TalkRoom saveTalkRoom(TalkRoom talkRoom){
        return talkRoomRepository.save(talkRoom);
    }
    public Optional<TalkRoom> findTalkRoomById(Long id){
        return talkRoomRepository.findById(id);
    }
    // public void saveTalkRoomWithUsers(TalkRoom talkRoom, Set<User>users){
    //     talkRoom.setUsers(users);
    //     talkRoomRepository.save(talkRoom);
    // }

    @Transactional
    public void updateTalkRoomWithUsers(TalkRoom updatedTalkRoom ,Set<User> updatedUsers){
        TalkRoom existiongTalkRoom = talkRoomRepository.findById(updatedTalkRoom.getId()).orElseThrow(()->new EntityNotFoundException());

        existiongTalkRoom.setName(updatedTalkRoom.getName());
        existiongTalkRoom.setUsers(updatedUsers);
        talkRoomRepository.save(existiongTalkRoom);
    }
    @Transactional
    public void deleteTalkRoom(Long id){
        TalkRoom talkRoom = findTalkRoomById(id).orElseThrow(()->new EntityNotFoundException());
        talkRoom.getUsers().clear();
        talkRoomRepository.delete(talkRoom);
    }

    public void saveTalkRoomWithUsers(TalkRoom talkRoom, Set<User> users) {
    // TalkRoomに関連するUserをセット
    talkRoom.setUsers(users);

    // User側にもTalkRoomをセット
    for (User user : users) {
        if (user.getTalkrooms() == null) {
            user.setTalkrooms(new HashSet<>());
        }
        user.getTalkrooms().add(talkRoom);
    }

    // TalkRoomを保存
    talkRoomRepository.save(talkRoom);

    // Userも保存 (必要に応じて)
    for (User user : users) {
        userRepository.save(user);
    }
}
}
