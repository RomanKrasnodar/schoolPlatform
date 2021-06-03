package com.schoolplatform.school.entity.student;

import com.schoolplatform.school.entity.classId.UniqueClass;
import com.schoolplatform.school.entity.classLevel.Parallel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;


@Entity
@Table(name = "students")
@Getter
@Setter
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name = "unique_class_id", referencedColumnName = "unique_class_id")
    private UniqueClass uniqueClass;

    @ManyToOne
    @JoinColumn(name = "parallel_id", referencedColumnName = "parallel_id")
    private Parallel parallel;

    public Student() {
    }

    public Student(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
//        this.classLevel = getClassLevelFromAge(this);
    }

    public int getClassLevelFromAge(Student student) {
        LocalDate now = LocalDate.now(ZoneId.systemDefault());
        int age = (int) ChronoUnit.YEARS.between(student.getBirthDate(), now);
        if (age > 6 && age < 18) {
            return age - 6;
        } else return 0;
    }

}
