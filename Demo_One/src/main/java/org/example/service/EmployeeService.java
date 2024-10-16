package org.example.service;

import org.example.model.Dependent;
import org.example.model.Employee;
import java.util.List;

public interface EmployeeService {
    void addEmployee(Employee employee);
    List<Employee> getAllEmployees();
    void addDependent(Dependent dependent);
}
