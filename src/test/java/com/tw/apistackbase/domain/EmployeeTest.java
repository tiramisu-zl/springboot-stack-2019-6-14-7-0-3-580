package com.tw.apistackbase.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void should_have_name_age_gender() {
        Employee employee = new Employee("Tom", "Male", 21);
        assertSame(employee.getAge(), 21);
        assertSame(employee.getGender(), "Male");
        assertSame(employee.getName(), "Tom");
    }

    @Test
    void should_set_name_age_gender() {
        Employee employee = new Employee();
        employee.setName("Tom");
        employee.setGender("Male");
        employee.setAge(21);
        assertSame(employee.getAge(), 21);
        assertSame(employee.getGender(), "Male");
        assertSame(employee.getName(), "Tom");
    }

    @Test
    void should_toString() {
        Employee employee = new Employee("Tom", "Male", 21);
        employee.setId(1);
        assertEquals(employee.toString(), "Employee{" +
                "id=1" +
                ", age=21"+
                ", name='Tom'" +
                ", gender='Male'" +
                '}');

    }
}