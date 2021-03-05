package com.schoolplatform.school.controller.classLevelController;

import com.schoolplatform.school.service.classLevelService.ClassLevelService;
import org.springframework.beans.factory.annotation.Autowired;

public class ClassLevelControllerImpl implements ClassLevelController{

    @Autowired
    public ClassLevelService classLevelService;
}
