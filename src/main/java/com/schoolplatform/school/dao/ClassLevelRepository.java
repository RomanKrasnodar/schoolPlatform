package com.schoolplatform.school.dao;

import com.schoolplatform.school.entity.classLevel.ClassLevelImpl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassLevelRepository extends JpaRepository<ClassLevelImpl, Integer> {
}
