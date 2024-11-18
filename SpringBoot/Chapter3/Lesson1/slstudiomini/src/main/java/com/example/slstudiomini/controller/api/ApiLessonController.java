package com.example.slstudiomini.controller.api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.slstudiomini.exception.MyLessonNotFoundException;
import com.example.slstudiomini.model.Lesson;
import com.example.slstudiomini.service.LessonService;

@RestController
@RequestMapping("api/lessons")
public class ApiLessonController {

    @Autowired
    private LessonService lessonService;

    @GetMapping
    public List<String> index(){
        List<Lesson>lessons = lessonService.findAllLessons();
        List<String>names = lessons.stream().map(x->x.getName()).collect(Collectors.toList());
        return names;
    }
    @GetMapping("/{id}")
    public Lesson index2(@PathVariable("id")Long id) throws MyLessonNotFoundException{
        return lessonService.findLessonById(id);
    }
    
}
