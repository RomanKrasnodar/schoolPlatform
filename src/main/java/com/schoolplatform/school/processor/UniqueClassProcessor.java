package com.schoolplatform.school.processor;

import com.schoolplatform.school.entity.classId.UniqueClass;
import com.schoolplatform.school.entity.student.Student;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface UniqueClassProcessor {
    List<Student> findAllFreeStudents(List<Student> allStudents);
    List<UniqueClass> addUniqueClasses(List<Student> allStudents);



    List<UniqueClass> createAllUniqueClasses(Map<Integer,Integer> classLevelToFreeStudents);
}
