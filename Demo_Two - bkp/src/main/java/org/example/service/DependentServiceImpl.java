package org.example.service;

import org.example.entity.Dependent;
import org.example.repository.DependentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DependentServiceImpl {
    @Autowired
    private DependentRepository dependentRepository;

    public List<Dependent> getDependentsByEmployeeId(Long employeeId) {
        return dependentRepository.findByEmployeeId(employeeId);
    }
}
