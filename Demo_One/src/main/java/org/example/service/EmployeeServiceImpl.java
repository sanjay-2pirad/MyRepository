package org.example.service;

import org.example.model.Dependent;
import org.example.model.Employee;
import org.example.repository.DependentRepository;
import org.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DependentRepository dependentRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, DependentRepository dependentRepository) {
        this.employeeRepository = employeeRepository;
        this.dependentRepository = dependentRepository;
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee); // Use JPA's save method
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll(); // Use JPA's findAll method
    }

    @Override
    public void addDependent(Dependent dependent) {
        dependentRepository.save(dependent); // Use JPA's save method
    }
}
