package com.example.controllers;

import com.example.domain.Image;
import com.example.domain.Student;
import com.example.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class StudentController {

    private final StudentServiceImpl studentService;

    @Autowired
    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String student() {
        return "index";
    }

    @PostMapping("/cabinet")
    public String registerStudent(
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam int age,
            @RequestParam("image") MultipartFile file) {
        Image image = new Image();
        image.setName(file.getOriginalFilename());
        image.setSize(file.getSize());

        Student student = Student.builder().name(name).surname(surname).age(age).image(image).build();
        studentService.saveStudent(student);

        saveFile(file);

        return "redirect:/cabinet/" + student.getId();
    }

    private void saveFile(MultipartFile file) {
        try {
            Files.createDirectories(Paths.get("target/classes/static/images/"));
            String folder = "target/classes/static/images/";

            byte[] bytes = file.getBytes();
            Path path = Paths.get(folder + file.getOriginalFilename());
            Files.write(path, bytes);
        } catch (Exception e) {
            System.out.println("Something went wrong during file saving...");
        }
    }

    @GetMapping("/cabinet/{id}")
    public String showStudentCabinet(@PathVariable int id, Model model) {
        Student student = studentService.getStudentById(id);

        if (student != null) {
            model.addAttribute("student", student);

            return "cabinet";
        } else {
            return "student_not_found";
        }
    }
}
