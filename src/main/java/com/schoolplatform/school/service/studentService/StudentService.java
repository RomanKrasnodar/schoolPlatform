package com.schoolplatform.school.service.studentService;

import com.schoolplatform.school.entity.student.Student;

import java.util.List;

public interface StudentService {
    public List<Student> findAll();
    public List<Student> getStudentById(int id);
    public Student save(Student student);
}
