package com.schoolplatform.school.entity.classId;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "class_id")
@Getter
@Setter
@RequiredArgsConstructor
public class ClassIdImpl implements ClassId{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id_id")
    private int id;

    @Column(name = "class_id_name")
    private String name;

    @Column(name = "classroom_teacher")
    private String classroomTeacher;

    @Column(name = "classroom_number")
    private int classroomNumber;

    @Column(name = "schedule")
    private String schedule;

}
