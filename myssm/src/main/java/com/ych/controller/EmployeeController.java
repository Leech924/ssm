package com.ych.controller;

import com.github.pagehelper.PageInfo;
import com.ych.pojo.Employee;
import com.ych.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 查询所有员工信息 /employee/ -->get
 * 查询员工的分页信息 /employee/page/1 -->get
 * 根据指定id查询员工信息 /employee/1 -->get
 * 跳转到添加页面 /to/add -->get
 * 添加一个员工 /employee/ -->post
 * 删除一个员工 /employee/1 -->delete
 * 修改员工信息 /employee/ -->put
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
//    查询员工的分页信息
    @RequestMapping(value ="/employee/page/{pageNum}",method = RequestMethod.GET)
    public String getEmployeePage(@PathVariable("pageNum") Integer pageNum,Model model){
        PageInfo<Employee> page = employeeService.getEmployeePage(pageNum);
        model.addAttribute("page",page);
        return "employee_list";
    }

    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public String getAllEmployee(Model model){
        //查询所有员工信息
        List<Employee> employeeList = employeeService.getEmployeeList();
        //将员工信息在请求域中共享
        model.addAttribute("list",employeeList);
        //跳转到employee_list.html
        return "employee_list";
    }
    @RequestMapping(value = "/abc")
    public String abc(){
        return "abc";
    }
}
