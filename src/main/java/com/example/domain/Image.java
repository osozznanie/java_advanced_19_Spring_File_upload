package com.example.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "images")
@Data
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private long size;
    @OneToOne(mappedBy = "image")
    private Student student;
}
