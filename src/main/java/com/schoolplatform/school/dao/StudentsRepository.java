package com.schoolplatform.school.dao;

import com.schoolplatform.school.entity.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentsRepository extends JpaRepository<Student,Integer> {

    public List<Student> findAll();
    public List<Student> getStudentById(int id);
    public Student save(Student student);
    public Student deleteById(int id);

}
