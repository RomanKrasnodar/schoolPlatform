package com.schoolplatform.school.entity.classId;

import com.schoolplatform.school.entity.classLevel.Parallel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "unique_classes")
@Data
@RequiredArgsConstructor
public class UniqueClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unique_class_id")
    private int id;

    @Column(name = "unique_class_name")
    private String name;

    @Column(name = "classroom_teacher_id")
    private String classroomTeacherId;

    @Column(name = "home_classroom_id")
    private int classroomNumber;

    @ManyToOne
    @JoinColumn(name = "parallel_id", referencedColumnName = "parallel_id")
    private Parallel parallel;


    public UniqueClass(String name) {
        this.name = name;
    }

}
