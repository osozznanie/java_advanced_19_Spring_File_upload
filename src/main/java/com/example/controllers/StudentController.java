package com.example.controllers;

import com.example.domain.Student;
import com.example.service.impl.StudentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Controller
@RequiredArgsConstructor
public class StudentController {

    @Autowired
    private final StudentServiceImpl studentService;


    @GetMapping("/")
    public String student() {

        return "index";
    }


    @PostMapping("/cabinet")
    public String registerStudent(Model model,
                                  @RequestParam String name,
                                  @RequestParam String surname,
                                  @RequestParam int age,
                                  @RequestParam("avatar") MultipartFile avatar) {
        Student student = new Student();
        student.setName(name);
        student.setSurname(surname);
        student.setAge(age);

        if (!avatar.isEmpty()) {
            try {
                byte[] avatarBytes = avatar.getBytes();
                student.setAvatar(avatarBytes);

                student.setFileName(avatar.getOriginalFilename());
                student.setFileType(avatar.getContentType());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        byte[] imageBytes = student.getAvatar();
        model.addAttribute("imageBytes", imageBytes);

        studentService.saveStudent(student);

        return "redirect:/cabinet/" + student.getId();
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
