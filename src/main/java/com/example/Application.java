package com.example;

import com.example.service.StudentService;
import com.example.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

//        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
//
//        StudentService studentService = context.getBean(StudentService.class);
//        studentService.deleteAll();
//
//
//        context.close();
        SpringApplication.run(Application.class, args);



    }

}
