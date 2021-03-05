package com.schoolplatform.school.entity.student;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "students")
@Getter
@Setter
public class StudentImpl implements Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int id;

    @Column(name = "full_name")
    private String name;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "class_level")
    private int classLevelName;

    @Column(name = "class_id")
    private String classIdName;

    public StudentImpl() {
    }

    public StudentImpl(int id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public StudentImpl(String name,LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
//        ClassLevel.getClassLVLFromAge(this);
    }
}
