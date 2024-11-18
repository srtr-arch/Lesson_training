package com.example.slstudiomini.exception;

public class MyLessonNotFoundException extends Exception {
    private Long id;
    public MyLessonNotFoundException(String message,Long id){
        super(message);
        this.id=id;
    }
    public Long getId() {
        return id;
    }
    
    
}
