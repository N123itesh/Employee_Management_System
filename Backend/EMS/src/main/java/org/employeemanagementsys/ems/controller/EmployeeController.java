package org.employeemanagementsys.ems.controller;


import lombok.RequiredArgsConstructor;
import org.employeemanagementsys.ems.model.Employees;
import org.employeemanagementsys.ems.service.IEmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final IEmployeeService employeeService;
    @GetMapping

    public ResponseEntity<List<Employees>> getEmployees(){
        return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.FOUND);
    }
    @PostMapping
    public Employees addEmployees(@RequestBody Employees employees){
        return employeeService.addEmployee(employees);
    }
    @PutMapping("/update/{id}")
    public Employees updateEmployees(@RequestBody Employees employees, @PathVariable Long id){
        return employeeService.updateEmployees(employees, id);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteEmployees(@PathVariable Long id){
        employeeService.deleteEmployees(id);
    }
    @GetMapping("/employee/{id}")
    public Employees getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeesById(id);
    }

}
