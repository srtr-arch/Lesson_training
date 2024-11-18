package com.example.slstudiomini.batch;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime(){
        System.out.println("現在時刻："+System.currentTimeMillis());
    }
    
}
