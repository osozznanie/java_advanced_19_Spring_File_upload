package com.example.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private int age;
    @Lob
    @Column(name = "avatar", columnDefinition="MEDIUMBLOB")
    private byte[] avatar;
    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_type")
    private String fileType;
    public Student() {

    }



}
