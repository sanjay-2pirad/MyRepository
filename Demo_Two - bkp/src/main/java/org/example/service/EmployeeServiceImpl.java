package org.example.service;

import org.example.entity.Employee;
import org.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
