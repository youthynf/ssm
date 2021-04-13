package com.study.controller;

import com.study.bean.Emp;
import com.study.dao.EmpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
    @Autowired
    EmpDao empDao;

    @RequestMapping("/test")
    public String test() {
        System.out.println("test");
        Emp empByEmpno = empDao.findEmpByEmpno(1);
        System.out.println(empByEmpno);
        return "success";
    }

    @RequestMapping("/getEmp")
    public ModelAndView getEmp(Integer id) {
        System.out.println(id);
        Emp empByEmpno = empDao.findEmpByEmpno(id);
        System.out.println(empByEmpno);
        // ModelAndView使用
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("emp", empByEmpno);
        modelAndView.setViewName("emp");
        return modelAndView;
    }
}
