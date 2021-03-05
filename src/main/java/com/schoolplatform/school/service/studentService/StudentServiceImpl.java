package com.schoolplatform.school.service.studentService;

import com.schoolplatform.school.dao.StudentsRepository;
import com.schoolplatform.school.entity.student.Student;
import com.schoolplatform.school.studentsGenerator.StudentsGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    public StudentsRepository studentsRepository;
    @Autowired
    public StudentsGenerator studentsGenerator;


    @Override
    public List<Student> findAll() {
        return studentsRepository.findAll();
    }

    @Override
    public List<Student> getStudentById(int id) {
        return studentsRepository.getStudentById(id);
    }

    @Override
    public Student save(Student student) {
        studentsRepository.save(student);
        return student;
    }


    @Override
    public String deleteById(int id) {
        studentsRepository.deleteById(id);
        return "Student with ID = " + id + " was deleted";
    }

    @Override
    public List<Student> saveAll(List<Student> students) {
        return studentsRepository.saveAll(students);
    }

    @Override
    public List<Student> generateAndSaveStudentsByNumber(int number) {
        List<Student> students = studentsGenerator.generateStudents(number);
        studentsRepository.saveAll(students);
        return students;
    }

}
