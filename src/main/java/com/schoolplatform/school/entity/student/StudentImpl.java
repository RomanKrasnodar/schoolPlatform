package com.schoolplatform.school.entity.student;

import com.schoolplatform.school.entity.classId.ClassIdImpl;
import com.schoolplatform.school.entity.classLevel.ClassLevel;
import com.schoolplatform.school.entity.classLevel.ClassLevelImpl;
import com.schoolplatform.school.studentsGenerator.StudentsGenerator;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

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

    @Column(name = "class_level_id")
    private int classLevelId;

    @Column(name = "class_id_Id")
    private int classIdId;

    public StudentImpl() {
    }

    public StudentImpl(int id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }
//for manual add
    public StudentImpl(String name,LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.classLevelId = StudentsGenerator.getClassLevelFromAge(birthDate);
    }
//    for generator

    public StudentImpl(String name, LocalDate birthDate, int classLevelId) {
        this.name = name;
        this.birthDate = birthDate;
        this.classLevelId = classLevelId;
    }
}
