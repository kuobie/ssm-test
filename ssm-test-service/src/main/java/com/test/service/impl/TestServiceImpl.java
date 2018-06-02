package com.test.service.impl;

import com.test.mapper.TestDao;
import com.test.pojo.TbUser;
import com.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;

    @Override
    public TbUser getService(Integer id) {
        TbUser tbUser = testDao.getUser(id);
        return tbUser;
    }
}
