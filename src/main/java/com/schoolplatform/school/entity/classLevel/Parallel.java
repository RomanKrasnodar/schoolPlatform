package com.schoolplatform.school.entity.classLevel;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "parallels")
@Data
@RequiredArgsConstructor
public class Parallel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parallel_id")
    private int id;

    @Column(name = "parallel_name")
    private String name;

    @Column(name = "teach_plan_id")
    private int teachPlan;


}
