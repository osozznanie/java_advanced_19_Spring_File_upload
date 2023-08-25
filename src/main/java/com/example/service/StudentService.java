package com.example.service;


import com.example.domain.Student;
import org.springframework.web.multipart.MultipartFile;

public interface StudentService {

     void saveStudent(Student student);
     Student getStudentById(int id);
     void deleteAll();
}
