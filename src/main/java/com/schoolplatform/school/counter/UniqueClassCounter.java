package com.schoolplatform.school.counter;

import com.schoolplatform.school.entity.student.Student;

import java.security.KeyStore;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface UniqueClassCounter {

    int countAllStudentsInClassLevel(int classLevel);
    int countNumberOfClasses(int numberOfStudents);
    int countNumberOfClasses(Map.Entry<Integer,Integer> classLevelToFreeStudents);
    Set<Integer> classLevelsToRefactoring(List<Student> allStudentsWithoutClasses);
    void setAllStudents(List<Student> allStudents);
}
