package org.example.service;

import org.example.entity.Employee;
import org.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }
   /*public Optional<Employee> getEmployeeByEmployeeId(Long employeeId)
   {
        Optional<Employee> employee= employeeRepository.findById(employeeId);
       return employee;
   }*/


    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeByEmployeeId(Long employeeId) {
        return employeeRepository.findById(employeeId);
    }
}
