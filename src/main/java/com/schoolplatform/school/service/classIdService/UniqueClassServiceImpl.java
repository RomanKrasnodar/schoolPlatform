package com.schoolplatform.school.service.classIdService;

import com.schoolplatform.school.dao.UniqueClassRepository;
import com.schoolplatform.school.dao.StudentsRepository;
import com.schoolplatform.school.entity.classId.UniqueClass;
import com.schoolplatform.school.entity.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UniqueClassServiceImpl implements UniqueClassService {

    public static final String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    public int maxStudentsInUniqueClass = 25;

    @Autowired
    public UniqueClassRepository uniqueClassRepository;
    @Autowired
    public StudentsRepository studentsRepository;

    @Override
    public List<Student> process() {
        List<Student> allStudents = new ArrayList<>();
        for (int i = 1; i < 12; i++) {
            List<Student> studentsInClassLevel = studentsRepository.findAllByClassLevel(i);
            int countNumberOfClasses = countNumberOfClasses(studentsInClassLevel.size());
            List<UniqueClass> uniqueClassesInClassLevel = addUniqueClassesInClassLevel(countNumberOfClasses, i);
            int uniqueClassIndex = 0;
            for (int a = 0; a < studentsInClassLevel.size(); a++) {
                Student student = studentsInClassLevel.get(a);
//                student.setUniqueClass(uniqueClassesInClassLevel.get(uniqueClassIndex).getName());
                allStudents.add(student);
                if (uniqueClassIndex < uniqueClassesInClassLevel.size()-1) {
                    uniqueClassIndex++;
                } else {
                    uniqueClassIndex = 0;
                }
            }
        }
        return allStudents;
    }

    private int countNumberOfClasses(int numberOfStudents) {
        int numberOfClassesInClassLevel = numberOfStudents / maxStudentsInUniqueClass;
        if ((numberOfStudents % maxStudentsInUniqueClass) > 0) {
            return numberOfClassesInClassLevel + 1;
        }
        return numberOfClassesInClassLevel;
    }


    public List<UniqueClass> addUniqueClassesInClassLevel(int numberOfClassesInClassLevel, int classLevelId) {
        List<UniqueClass> uniqueClassesInClassLevel = new ArrayList<>();
        for (int i = 0; i < numberOfClassesInClassLevel; i++) {
            uniqueClassesInClassLevel.add(new UniqueClass(classLevelId + letters[i]));
        }
        Set<UniqueClass> uniqueClassSet = uniqueClassSet(uniqueClassesInClassLevel);
        uniqueClassRepository.saveAll(uniqueClassSet);
        uniqueClassesInClassLevel.clear();
        uniqueClassesInClassLevel.addAll(uniqueClassSet);
        return uniqueClassesInClassLevel;
    }

    public Set<UniqueClass> uniqueClassSet(List<UniqueClass> uniqueClassList){
        Set<UniqueClass> uniqueClassSet = new HashSet<>(uniqueClassList);
        return uniqueClassSet;
    }








}
