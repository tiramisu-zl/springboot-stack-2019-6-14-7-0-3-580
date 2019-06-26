package com.tw.apistackbase.controller;

import com.tw.apistackbase.domain.Employee;
import com.tw.apistackbase.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

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
    public Employee add(@RequestBody Employee employee){

        employeeRepository.add(employee);

        return employee;
    }

    @GetMapping("/")
    public Collection<Employee> getAll(){
        Collection<Employee> result = employeeRepository.getAll();
        return result;
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Employee> put(@PathVariable int id, @RequestBody Employee employee) {
        Employee e;

        try {
            e = employeeRepository.update(id, employee);
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(e);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        employeeRepository.delete(id);

        return ResponseEntity.ok().build();
    }

}
