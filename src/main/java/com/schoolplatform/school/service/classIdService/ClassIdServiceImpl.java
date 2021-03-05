package com.schoolplatform.school.service.classIdService;

import com.schoolplatform.school.dao.ClassIdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassIdServiceImpl implements ClassIdService {

    @Autowired
    public ClassIdRepository classIdRepository;
}
