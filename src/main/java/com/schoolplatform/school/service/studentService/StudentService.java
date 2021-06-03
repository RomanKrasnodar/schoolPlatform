package com.schoolplatform.school.service.studentService;

import com.schoolplatform.school.entity.student.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();

    List<Student> getStudentById(int id);

    Student save(Student student);

    String deleteById(int id);

    List<Student> saveAll(List<Student> students);

    List<Student> generateAndSaveStudentsByNumber(int number);


}
