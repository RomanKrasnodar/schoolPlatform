package com.schoolplatform.school.entity.classLevel;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "class_level")
@Getter
@Setter
@RequiredArgsConstructor
public class ClassLevelImpl implements ClassLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_level_id")
    private int id;

    @Column(name = "class_level_name")
    private String name;



}
