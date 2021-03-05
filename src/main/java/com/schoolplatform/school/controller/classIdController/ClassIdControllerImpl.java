package com.schoolplatform.school.controller.classIdController;

import com.schoolplatform.school.service.classIdService.ClassIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/classId")
public class ClassIdControllerImpl implements ClassIdController{

    @Autowired
    public ClassIdService classIdService;
}
