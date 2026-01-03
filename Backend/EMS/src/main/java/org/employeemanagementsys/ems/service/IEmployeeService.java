package org.employeemanagementsys.ems.service;

import org.employeemanagementsys.ems.model.Employees;

import java.util.List;

public interface IEmployeeService {
    Employees addEmployee(Employees employees);
    List<Employees> getEmployees();

    Employees updateEmployees(Employees employees, Long id);

    Employees getEmployeesById(Long id);

    void deleteEmployees(Long id);

}
