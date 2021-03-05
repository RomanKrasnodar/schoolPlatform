package com.schoolplatform.school.dao;

import com.schoolplatform.school.entity.classId.ClassId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassIdRepository extends JpaRepository<ClassId,Integer> {
}
