package com.schoolplatform.school.service.classLevelService;

import com.schoolplatform.school.entity.classLevel.Parallel;
import com.schoolplatform.school.entity.student.Student;

import java.util.List;

public interface ClassLevelService {

    Parallel save(Parallel classLevel);

    List<Student> setClassLevelToAllStudent();

    Student setClassLevelToOneStudent(Student student);
}
