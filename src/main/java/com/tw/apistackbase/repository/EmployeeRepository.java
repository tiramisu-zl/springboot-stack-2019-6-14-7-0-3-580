package com.tw.apistackbase.repository;

import com.tw.apistackbase.domain.Employee;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class EmployeeRepository {

    /**
     * 采用内存型的存储方式
     */
    private final ConcurrentMap<Integer, Employee> repository = new ConcurrentHashMap<>();

    private final static AtomicInteger idGenerator = new AtomicInteger();

    public boolean add(Employee employee) {
        // id 从 1 开始
        Integer id = idGenerator.incrementAndGet();
        employee.setId(id);
        return repository.put(id, employee) == null;
    }
}
