package org.example.service;

import org.example.entity.Dependent;
import org.example.entity.Employee;
import org.example.repository.DependentRepository;
import org.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class DependentServiceImpl {
    @Autowired
    private DependentRepository dependentRepository;
    private EmployeeRepository employeeRepository;
    public List<Dependent> getDependentsByEmployee(Employee employee) {
        return dependentRepository.findByEmployee(employee);
    }
}
