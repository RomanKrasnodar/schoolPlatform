package com.schoolplatform.school.service.studentService;

import com.schoolplatform.school.entity.student.Student;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface StudentService {
    public List<Student> findAll();
    public List<Student> getStudentById(int id);
    public Student save(Student student);
    public String deleteById(int id);
    public List<Student> saveAll(List<Student> students);
    public List<Student> generateAndSaveStudentsByNumber(int number);
}
