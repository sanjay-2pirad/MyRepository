package org.example.repository;

import org.example.entity.Dependent;
import org.example.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DependentRepository extends JpaRepository<Dependent, Long> {
    List<Dependent> findByEmployee(Employee employee);
}
