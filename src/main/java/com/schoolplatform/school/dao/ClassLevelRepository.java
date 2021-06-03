package com.schoolplatform.school.dao;

import com.schoolplatform.school.entity.classLevel.Parallel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassLevelRepository extends JpaRepository<Parallel, Integer> {

    public Parallel findByClassLevel(int classLevel);


}
