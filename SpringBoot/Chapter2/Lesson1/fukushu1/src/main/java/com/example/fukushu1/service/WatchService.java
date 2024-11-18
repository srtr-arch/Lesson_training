package com.example.fukushu1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fukushu1.model.Watch;
import com.example.fukushu1.repository.WatchRepository;

@Service
public class WatchService {
    @Autowired
    private WatchRepository watchRepository;

    public List<Watch> findAllWatches(){
        List<Watch>watches = watchRepository.findAll();
        return watches;
    }
    public Watch saveWatch(Watch watch){
        return watchRepository.save(watch);
    }
}
