package com.schoolplatform.school.counter;

import com.schoolplatform.school.entity.student.Student;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@RequiredArgsConstructor
public class UniqueClassCounterImpl implements UniqueClassCounter{
    public static final int MAX_STUDENTS_IN_UNIQUE_CLASS = 25;
    private List<Student> allStudents = new ArrayList<>();



    @Override
    public int countAllStudentsInClassLevel(int classLevel) {
        int counter = 0;
        for(Student student : allStudents){
            if(classLevel == student.getUniqueClass().getParallel().getId()){
                counter++;
            }
        }
        return counter;
    }

    @Override
    public int countNumberOfClasses(int numberOfStudents) {
        int numberOfClassesInClassLevel = numberOfStudents / MAX_STUDENTS_IN_UNIQUE_CLASS;
        if ((numberOfStudents % MAX_STUDENTS_IN_UNIQUE_CLASS) > 0) {
            return numberOfClassesInClassLevel + 1;
        }
        return numberOfClassesInClassLevel;
    }

    @Override
    public int countNumberOfClasses(Map.Entry<Integer, Integer> classLevelToFreeStudents) {
        int classLevel = classLevelToFreeStudents.getKey();
        int allStudentsInClassLevel = countAllStudentsInClassLevel(classLevel);
        int numberOfUniqueClassesInClassLevel = countNumberOfClasses(allStudentsInClassLevel);
        return numberOfUniqueClassesInClassLevel;
    }


    @Override
    public Set<Integer> classLevelsToRefactoring(List<Student> allStudentsWithoutClasses) {
        Set<Integer> classLevelsWithFreeStudents = new HashSet<>();
        allStudentsWithoutClasses.forEach(student -> {
            classLevelsWithFreeStudents.add(student.getUniqueClass().getParallel().getId());
        });
        return classLevelsWithFreeStudents;
    }
}
