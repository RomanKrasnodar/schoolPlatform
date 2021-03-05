package com.schoolplatform.school.service.studentService;

import com.schoolplatform.school.entity.student.Student;
import com.schoolplatform.school.entity.student.StudentImpl;

import java.util.List;

public interface StudentService {
    public List<StudentImpl> findAll();
    public List<StudentImpl> getStudentById(int id);
    public Student save(Student student);
}
