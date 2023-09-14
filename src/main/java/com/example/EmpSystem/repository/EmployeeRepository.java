package com.example.EmpSystem.repository;

import com.example.EmpSystem.dto.EmployeeDTO;
import com.example.EmpSystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
