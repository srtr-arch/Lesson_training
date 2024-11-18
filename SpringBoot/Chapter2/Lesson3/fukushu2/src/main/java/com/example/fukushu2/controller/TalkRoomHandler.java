package com.example.fukushu2.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.fukushu2.model.TalkRoom;
import com.example.fukushu2.model.User;
import com.example.fukushu2.service.TalkRoomService;
import com.example.fukushu2.service.UserService;

import jakarta.persistence.EntityNotFoundException;

@Controller
@RequestMapping("/talkrooms")
public class TalkRoomHandler {

    @Autowired
    private TalkRoomService talkRoomService;
    @Autowired
    private UserService userService;
    
    @GetMapping()
    public String listTalkRoom(Model model){
        List<TalkRoom>talkrooms = talkRoomService.findAllTalkRooms();
        model.addAttribute("talkrooms", talkrooms);
        return "talkrooms/list";
    }
    @GetMapping("/add")
    public String addTalkRoomForm(Model model){
        model.addAttribute("talkroom",new TalkRoom());
        model.addAttribute("users",userService.findAllUsers());
        return "talkrooms/add";
    }
    @PostMapping("/add")
    public String addTalkRoom(TalkRoom talkRoom,@RequestParam(name="users")List<Long>users){
        // System.out.println(users.size()+"1111111");
        Set<User>userSet = new HashSet<>();
        for(Long userId:users){
        userSet.add(new User(userId));}
        System.out.println("Saving TalkRoom with users: "+userSet.toArray() );
        // System.out.println(userSet.size()+"1111111");

    // talkRoomService.saveTalkRoomWithUsers(talkRoom,userSet);
    talkRoomService.saveTalkRoom(talkRoom);
    return "redirect:/talkrooms";
    }
    @GetMapping("delete/{id}")
    public String deleteTalkRoom(@PathVariable(name="id")Long id){
        TalkRoom talkRoom = talkRoomService.findTalkRoomById(id).orElseThrow(()->new EntityNotFoundException());
        talkRoom.setDeleted(true);
        talkRoomService.saveTalkRoom(talkRoom);
        return "redirect:/talkrooms";
    }
    @GetMapping("edit/{id}")
    public String editTalkRoomForm(@PathVariable(name="id")Long id,Model model){
        TalkRoom talkRoom = talkRoomService.findTalkRoomById(id).orElseThrow(()->new EntityNotFoundException());
        model.addAttribute("talkroom", talkRoom);
        model.addAttribute("users", userService.findAllUsers());
        return "talkrooms/edit";
    }
    @GetMapping("edit")
    public String editTalkRoom(TalkRoom talkRoom,@RequestParam(name="users")List<Long>users){
        Set<User>userSet = users.stream().
        map(userId->new User(userId))
        .collect(Collectors.toSet());
        talkRoomService.updateTalkRoomWithUsers(talkRoom,userSet);

        return "redirect:/talkrooms";
    }

}
