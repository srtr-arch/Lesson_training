package com.example.fukushu1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.fukushu1.model.Watch;
import com.example.fukushu1.service.WatchService;

@Controller
@RequestMapping("/watches")
public class WatchController {
    @Autowired
    private WatchService watchService;
    @GetMapping("")
    public String listWatch(Model model){
        List<Watch>watches = watchService.findAllWatches();
        model.addAttribute("watches", watches);
        return "watches";

    }

    @GetMapping("/add")
    public String addWatchForm(Model model){
        model.addAttribute("watch", new Watch());
        return "add-watch";
    }
    @PostMapping("/add")
    public String addWatch(Watch watch){
        watchService.saveWatch(watch);
        return "redirect:/watches";
    }
}
