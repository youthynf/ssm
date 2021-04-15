package com.study.controller;

import com.alibaba.fastjson.JSONObject;
import com.study.bean.Emp;
import com.study.dao.EmpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    //返回json
    @RequestMapping("/json")
    @ResponseBody
    public JSONObject json(Integer id) {
        Emp empByEmpno = empDao.findEmpByEmpno(id);
        System.out.println(empByEmpno);
        return JSONObject.parseObject(JSONObject.toJSONString(empByEmpno));
    }

    @RequestMapping("/selectEmpAndDept")
    @ResponseBody
    public JSONObject selectEmpAndDept(Integer id) {
        System.out.println(id);
        Emp emp = empDao.selectEmpAndDept(id);
        System.out.println(emp);
        return JSONObject.parseObject(JSONObject.toJSONString(emp));
    }
}
