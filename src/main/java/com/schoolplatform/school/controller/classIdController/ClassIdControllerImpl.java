package com.schoolplatform.school.controller.classIdController;

import com.schoolplatform.school.service.classIdService.ClassIdService;
import org.springframework.beans.factory.annotation.Autowired;

public class ClassIdControllerImpl implements ClassIdController{

    @Autowired
    public ClassIdService classIdService;
}
