package com.schoolplatform.school.service.classLevelService;

import com.schoolplatform.school.dao.ClassLevelRepository;
import com.schoolplatform.school.dao.StudentsRepository;
import com.schoolplatform.school.entity.classLevel.Parallel;
import com.schoolplatform.school.entity.student.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ClassLevelServiceImpl implements ClassLevelService {

    @Autowired
    private final ClassLevelRepository classLevelRepository;
    @Autowired
    private final StudentsRepository studentsRepository;



    @Override
    public Student setClassLevelToOneStudent(Student student) {
        if(student == null){
            return student;
        }else {
            student.setClassLevel(student.getClassLevelFromAge(student));
        }
        return student;
    }

    @Override
    public List<Student> setClassLevelToAllStudent() {
        List<Student> allStudents = studentsRepository.findAll();
        List<Student> allStudentsWithClassLevel = new ArrayList<>();
        List<Parallel> classLevelList = classLevelRepository.findAll();

        allStudents.forEach(student -> {
            setClassLevelToOneStudent(student);
            Parallel classLevel = new Parallel();
//            classLevel.setClassLevel(student.getClassLevel());
            classLevelList.add(classLevel);
            allStudentsWithClassLevel.add(student);
        });
        studentsRepository.saveAll(allStudentsWithClassLevel);
        Set<Parallel> uniqueClassLevelSet = uniqueClassLevel(classLevelList);
        classLevelRepository.saveAll(uniqueClassLevelSet);
        return allStudentsWithClassLevel;
    }

    @Override
    public Parallel save(Parallel classLevel){
       classLevelRepository.save(classLevel);
       return classLevel;
    }

    public Set<Parallel> uniqueClassLevel(List<Parallel> classLevelList){
        Set<Parallel> uniqueClassLevelSet = new HashSet<>(classLevelList);
        return uniqueClassLevelSet;
    }


}
