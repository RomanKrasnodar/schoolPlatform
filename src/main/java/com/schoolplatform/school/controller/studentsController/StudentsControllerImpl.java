package com.schoolplatform.school.controller.studentsController;

import com.schoolplatform.school.service.studentService.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentsControllerImpl implements StudentsController{

    @Autowired
    public StudentService studentService;
}
