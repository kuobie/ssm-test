package com.test.controller;

import com.test.pojo.TbUser;
import com.test.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/index/{id}")
    @ResponseBody
    public TbUser getName(@PathVariable("id") Integer id) {
        TbUser tbUser = null;
        tbUser = testService.getService(id);

        return tbUser;

    }
}
