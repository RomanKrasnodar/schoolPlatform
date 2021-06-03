package com.schoolplatform.school.controller.classLevelController;

import com.schoolplatform.school.dao.StudentsRepository;
import com.schoolplatform.school.service.classLevelService.ClassLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/classLevel")
public class ClassLevelControllerImpl implements ClassLevelController {

    @Autowired
    public ClassLevelService classLevelService;
    @Autowired
    public StudentsRepository studentsRepository;


//    @PostMapping("/create")
//    public List<Parallel> createClassLevels() {
//        List<Parallel> classLevelList = new ArrayList<>();
//        for (int i = 0; i < 12; i++) {
//            classLevelList.add(new Parallel());
//        }
//        classLevelRepository.saveAll(classLevelList);
//        return classLevelList;
//    }
//
//
//    @PutMapping("/getClassLevelToAll")
//    public List<Parallel> getClassLevelToAllStudents() {
//        List<Parallel> classLevelList = classLevelRepository.findAll();
//
//        List<Student> allStudents = studentsRepository.findAll();
//        allStudents.forEach(student -> {
//            int classLevelId = student.getClassLevelFromAge(student.getBirthDate());
//            student.setClassLevel(classLevelList.get(classLevelId));
//            classLevelList.get(classLevelId).getStudentsInClassLevel().add(student);
//        });
//        studentsRepository.saveAll(allStudents);
//        classLevelRepository.saveAll(classLevelList);
//        return classLevelList;
//    }

//    @GetMapping("/getClassLevelToStudent")
//    public Parallel getClassLevelToStudent(@PathVariable Student student){
//        Parallel classLevel = classLevelService.getClassLevelToStudent(student);
//        return classLevel;
//    }
}
