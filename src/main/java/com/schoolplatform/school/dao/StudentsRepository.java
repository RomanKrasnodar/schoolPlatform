package com.schoolplatform.school.dao;

import com.schoolplatform.school.entity.student.Student;
import com.schoolplatform.school.entity.student.StudentImpl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentsRepository extends JpaRepository<StudentImpl,Integer> {

    public List<StudentImpl> findAll();
    public List<StudentImpl> getStudentById(int id);
    public StudentImpl save(StudentImpl student);
    public StudentImpl deleteById(int id);

}
