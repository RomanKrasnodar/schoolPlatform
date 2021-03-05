package com.schoolplatform.school.controller.studentsController;

import com.schoolplatform.school.entity.student.Student;
import com.schoolplatform.school.entity.student.StudentImpl;
import com.schoolplatform.school.service.studentService.StudentService;
import com.schoolplatform.school.studentsGenerator.StudentsGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentsControllerImpl implements StudentsController {

    @Autowired
    public StudentService studentService;
    @Autowired
    public StudentsGenerator studentsGenerator;


    @GetMapping("/allStudents")
    public List<StudentImpl> showAllStudents() {
        List<StudentImpl> studentRepositoryAll = studentService.findAll();
        return studentRepositoryAll;
    }

    @PutMapping("/updateStudent")
    public StudentImpl updateStudent(@RequestBody StudentImpl student) {
        studentService.save(student);
        return student;
    }

    @PostMapping("/addStudent")
    public StudentImpl addNewStudent(@RequestBody StudentImpl student) {
        studentService.save(student);
        return student;
    }

    @DeleteMapping("/deleteStudent/{id}")
    public String deleteById(@PathVariable int id) {
        return studentService.deleteById(id);
    }

    @PostMapping("/generate/{number}")
    public List<StudentImpl> generateAndSaveStudentsByNumber(@PathVariable int number) {
        List<StudentImpl> students = studentsGenerator.generateStudents(number);
        studentService.saveAll(students);
        return students;
    }


}
