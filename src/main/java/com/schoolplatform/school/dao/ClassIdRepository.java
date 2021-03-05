package com.schoolplatform.school.dao;

import com.schoolplatform.school.entity.classId.UniqueClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassIdRepository extends JpaRepository<UniqueClass,Integer> {
}
