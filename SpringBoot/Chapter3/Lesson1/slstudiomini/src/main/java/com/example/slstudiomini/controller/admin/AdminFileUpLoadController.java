package com.example.slstudiomini.controller.admin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.slstudiomini.model.Course;
import com.example.slstudiomini.repository.CourseRepository;
import com.example.slstudiomini.service.CourseService;

@Controller
@RequestMapping("admin/upload")
public class AdminFileUpLoadController {
    private static String UPLOAD_FOLDER = "C:/SLStudio/SpringBoot/Chapter3/Lesson1/slstudiomini/src/main/resources/static/uploads/images/course/";

    @Autowired
    private CourseService courseService;

    @GetMapping("/{id}")
    public String uploadPNG(@PathVariable("id")Long id,Model model){
        model.addAttribute("id", id);
        return "admin/upload";
        
    }

    @PostMapping("")
    public String singleFileUpload(@RequestParam(name="file")MultipartFile file,@RequestParam("id")Long id){
        String originalFilename = file.getOriginalFilename();
String fileExtension = originalFilename != null ? originalFilename.substring(originalFilename.lastIndexOf(".") + 1).toLowerCase() : "";
if (!(fileExtension.equals("png"))) {
    return "許可されていないファイル形式です";
}
        

        try{
            Path path = Paths.get(UPLOAD_FOLDER+id+".png");
System.out.println(id+"!!!!!!!!!!!!!!!!!!!");
            Files.copy(file.getInputStream(),path,StandardCopyOption.REPLACE_EXISTING);
            Course course = courseService.findCourseById(id);
            course.setFilepath(UPLOAD_FOLDER+id+".png");
            courseService.save(course);
        }catch(IOException e){
            e.printStackTrace();
           System.out.println( "アップロード中にエラーが発生しました");
        }

        return "redirect:/admin/courses";
    }
    
}
