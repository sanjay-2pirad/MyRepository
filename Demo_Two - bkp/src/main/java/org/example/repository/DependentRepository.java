package org.example.repository;

import org.example.entity.Dependent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DependentRepository extends JpaRepository<Dependent, Long> {
    List<Dependent> findByEmployeeId(Long employeeId);
}
