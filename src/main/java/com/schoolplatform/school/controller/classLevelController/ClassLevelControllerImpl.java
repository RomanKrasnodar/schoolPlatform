package com.schoolplatform.school.controller.classLevelController;

import com.schoolplatform.school.service.classLevelService.ClassLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/classLevel")
public class ClassLevelControllerImpl implements ClassLevelController{

    @Autowired
    public ClassLevelService classLevelService;
}
