package com.schoolplatform.school.dao;

import com.schoolplatform.school.entity.classId.UniqueClass;
import com.schoolplatform.school.entity.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UniqueClassRepository extends JpaRepository<UniqueClass, Integer> {

//    public List<Student> setUniqueClassForAllStudents();

    public List<Integer> findDistinctByClassLevelId(int classLevelId);
}
