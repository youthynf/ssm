package com.study.controller;

import com.study.dao.EmpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

public class TestController {
    @Autowired
    EmpDao empDao;

    @RequestMapping("/test")
    public String test() {
        System.out.println("test");
        return "test";
    }
}
