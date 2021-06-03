package com.schoolplatform.school.processor;

import com.schoolplatform.school.counter.UniqueClassCounter;
import com.schoolplatform.school.entity.classId.UniqueClass;
import com.schoolplatform.school.entity.student.Student;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class UniqueClassProcessorImpl implements UniqueClassProcessor {

    public static final String[] LETTERS = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    public static final int MAX_STUDENTS_IN_UNIQUE_CLASS = 25; // надо ли?

    @Autowired
    UniqueClassCounter counter;

    //Нужно понять как оставить уже распределённых студентов в их классах и как создать новые классы и добавить туда новых студентов

    public List<UniqueClass> addUniqueClasses(List<Student> allStudents) {
        List<Student> allFreeStudents = findAllFreeStudents(allStudents);
        Set<Integer> uniqueClassLevelsWithFreeStudents = counter.classLevelsToRefactoring(allFreeStudents);
        Map<Integer, Integer> classLevelsToFreeStudents = countAndAddFreeStudentsToClassLevels(uniqueClassLevelsWithFreeStudents, allFreeStudents);
        List<UniqueClass> allUniqueClasses = createAllUniqueClasses(classLevelsToFreeStudents);
        return allUniqueClasses;
    }

    @Override
    public List<Student> findAllFreeStudents(List<Student> allStudents) {
        List<Student> studentsWithoutClasses = new ArrayList<>();
        for (Student student : allStudents) {
            if (student.getUniqueClass() == null) {
                studentsWithoutClasses.add(student);
            }
        }
        return studentsWithoutClasses;
    }

    @Override
    public List<UniqueClass> createAllUniqueClasses(Map<Integer, Integer> classLevelToFreeStudents) {
        List<UniqueClass> allUniqueClasses = new ArrayList<>();
        Iterator<Map.Entry<Integer, Integer>> entries = classLevelToFreeStudents.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<Integer, Integer> entry = entries.next();
            int classLevel = entry.getKey();
            int numberOfUniqueClassesInClassLevel = counter.countNumberOfClasses(entry);
            List<UniqueClass> uniqueClassesInClassLevel = createUniqueClasses(numberOfUniqueClassesInClassLevel,classLevel);
            allUniqueClasses.addAll(uniqueClassesInClassLevel);
        }
        return allUniqueClasses;
    }

//Переделать - считать должен Counter, а название этого метода будет createFreeStudentsToClassLevels
    public Map<Integer, Integer> countAndAddFreeStudentsToClassLevels(Set<Integer> classLevels, List<Student> students) {
        Map<Integer, Integer> classLevelToFreeStudents = new HashMap<>();
        Iterator<Integer> iterator = classLevels.iterator();
        while (iterator.hasNext()) {
            int classLevel = iterator.next();
            int freeStudentsInClassLevelCounter = 0;
            for (Student student : students) {
                if (classLevel == student.getUniqueClass().getParallel().getId()) {
                    freeStudentsInClassLevelCounter++;
                }
            }
            classLevelToFreeStudents.put(classLevel, freeStudentsInClassLevelCounter);
        }
        return classLevelToFreeStudents;
    }

    public List<UniqueClass> createUniqueClasses(int numberOfClasses, int classLevel) {
        List<UniqueClass> uniqueClassesInClassLevel = new ArrayList<>();
        for (int i = 0; i < numberOfClasses; i++) {
            uniqueClassesInClassLevel.add(new UniqueClass(classLevel + LETTERS[i]));
        }
        return uniqueClassesInClassLevel;
    }


}
