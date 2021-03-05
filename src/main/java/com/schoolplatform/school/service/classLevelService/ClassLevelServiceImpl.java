package com.schoolplatform.school.service.classLevelService;

import com.schoolplatform.school.dao.ClassLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassLevelServiceImpl implements ClassLevelService {

    @Autowired
    public ClassLevelRepository classLevelRepository;
}
