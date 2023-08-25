package com.example.service.impl;

import com.example.domain.Student;
import com.example.repository.StudentRepository;
import com.example.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RequiredArgsConstructor
@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private final StudentRepository studentRepository;


    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepository.getReferenceById((long) id);
    }

    @Override
    public void deleteAll() {
        studentRepository.deleteAll();
    }
}
