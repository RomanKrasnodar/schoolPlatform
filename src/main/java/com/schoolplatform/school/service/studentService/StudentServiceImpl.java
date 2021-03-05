package com.schoolplatform.school.service.studentService;

import com.schoolplatform.school.dao.StudentsRepository;
import com.schoolplatform.school.entity.student.Student;
import com.schoolplatform.school.entity.student.StudentImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Student save(Student student) {
        return studentsRepository.save(student);
    }
}
