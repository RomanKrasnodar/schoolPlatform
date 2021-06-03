package com.schoolplatform.school.controller.classIdController;

import com.schoolplatform.school.entity.student.Student;
import com.schoolplatform.school.service.classIdService.UniqueClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/classId")
public class UniqueClassControllerImpl implements UniqueClassController {

    @Autowired
    public UniqueClassService uniqueClassService;

    @PutMapping("/setUniClasses")
    public List<Student> distributionAllStudentsByUniqueClasses(){
        return uniqueClassService.process();
    }
}
