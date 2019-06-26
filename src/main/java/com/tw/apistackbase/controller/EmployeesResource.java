package com.tw.apistackbase.controller;

import com.tw.apistackbase.domain.Employee;
import com.tw.apistackbase.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeesResource {

    /**
     * 构造器注入方式
     */
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeesResource(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostMapping("/add")
    public Employee add(@RequestParam String name, String gender, int age){
        Employee employee = new Employee(name, gender, age);

        if (employeeRepository.add(employee)) {
            System.out.printf("employ %s 添加成功\n", employee);
        }

        return employee;
    }

}
