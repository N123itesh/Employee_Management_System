package org.employeemanagementsys.ems.repo;

import org.employeemanagementsys.ems.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employees, Long> {
    Optional<Employees> findByEmail(String email);
}
