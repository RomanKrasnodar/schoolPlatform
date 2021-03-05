package com.schoolplatform.school.service.studentService;

import com.schoolplatform.school.dao.StudentsRepository;
import com.schoolplatform.school.entity.student.Student;
import com.schoolplatform.school.entity.student.StudentImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    public StudentsRepository studentsRepository;


    @Override
    public List<StudentImpl> findAll() {
        return studentsRepository.findAll();
    }

    @Override
    public List<StudentImpl> getStudentById(int id) {
        return studentsRepository.getStudentById(id);
    }

    @Override
    public StudentImpl save(StudentImpl student) {
        studentsRepository.save(student);
        return student;
    }


    @Override
    public String deleteById(int id) {
        studentsRepository.deleteById(id);
        return "Student with ID = " + id + " was deleted";
    }

    @Override
    public List<StudentImpl> saveAll(List<StudentImpl> students) {
        return studentsRepository.saveAll(students);
    }

}
