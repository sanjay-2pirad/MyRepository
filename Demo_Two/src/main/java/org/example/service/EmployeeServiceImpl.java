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
    @Autowired
    EmployeeJmsProducer employeeJmsProducer;

    public Employee saveEmployee(Employee employee) {
        Employee savedEmployee=employeeRepository.save(employee);
        employeeJmsProducer.sendEmployeeCreatedMessage(savedEmployee);
        return savedEmployee;
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

    //Jms specific method

    /*public Employee createEmployee(Employee employee) {
        Employee savedEmployee = employeeRepository.save(employee);

        employeeJmsProducer.sendEmployeeCreatedMessage(savedEmployee);
        return savedEmployee;
    }*/
}
