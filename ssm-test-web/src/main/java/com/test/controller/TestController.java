package com.test.controller;

import com.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/index")
    public String getName() {
        String s = null;
        try {
            s = testService.getService("你好");
        } catch (Exception e) {

            e.printStackTrace();
        }

        return s;

    }
}
