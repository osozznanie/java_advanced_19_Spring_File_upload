package com.example.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "students")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private int age;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "imageId", referencedColumnName = "id")
    private Image image;
}
