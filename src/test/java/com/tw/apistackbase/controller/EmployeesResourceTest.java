package com.tw.apistackbase.controller;

import com.tw.apistackbase.Exceptions.NotFoundEmployeeException;
import com.tw.apistackbase.domain.Employee;
import com.tw.apistackbase.repository.EmployeeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class EmployeesResourceTest {
    private EmployeesResource employeesResource;

    @Mock
    private EmployeeRepository mockEmployeeRepository;

    @Before
    public void setUp() {
        employeesResource = new EmployeesResource(mockEmployeeRepository);
    }

    @Test
    public void addTest() {
        Employee employee = new Employee("name", "male", 20);
        given(mockEmployeeRepository.add(any())).willReturn(true);

        Employee result = employeesResource.add(employee);

        assertEquals(result, employee);
        verify(mockEmployeeRepository).add(employee);
    }

    @Test
    public void getAllTest() {
        Collection<Employee> list = mock(Collection.class);
        given(mockEmployeeRepository.getAll()).willReturn(list);

        Collection<Employee> result = employeesResource.getAll();

        assertEquals(result, list);
        verify(mockEmployeeRepository).getAll();

    }

    @Test
    public void putTest() throws NotFoundEmployeeException {
        Employee employee = new Employee();
        given(mockEmployeeRepository.update(anyInt(), any())).willReturn(employee);

        ResponseEntity<Employee> result = employeesResource.put(1, employee);

        assertEquals(result, ResponseEntity.ok(employee));
    }

    @Test
    public void deleteTest() {
        employeesResource.delete(1);
        verify(mockEmployeeRepository).delete(1);

    }
}