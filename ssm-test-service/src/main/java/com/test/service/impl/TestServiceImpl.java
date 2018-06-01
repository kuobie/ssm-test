package com.test.service.impl;

import com.test.mapper.TestDao;
import com.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;

    @Override
    public String getService(String name) {
        System.out.println(name);
        String string = testDao.getString(name);
        return string;
    }
}
