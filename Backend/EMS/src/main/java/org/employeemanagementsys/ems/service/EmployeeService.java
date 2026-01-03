package org.employeemanagementsys.ems.service;

import lombok.RequiredArgsConstructor;
import org.employeemanagementsys.ems.Exception.EmployeeAlreadyExistsException;
import org.employeemanagementsys.ems.Exception.EmployeeNotFoundException;
import org.employeemanagementsys.ems.model.Employees;
import org.employeemanagementsys.ems.repo.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService implements IEmployeeService {
    private final EmployeeRepo employeeRepo;

    @Override
    public List<Employees> getEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public Employees addEmployee(Employees employees) {
        if (employeeAlreadyExists(employees.getEmail())){
            throw new EmployeeAlreadyExistsException(employees.getEmail() + "Already Exists!");
        }
        return employeeRepo.save(employees);
    }


    @Override
    public Employees updateEmployees(Employees employees, Long id) {
        return employeeRepo.findById(id).map(em -> {
            em.setFirstName(employees.getFirstName());
            em.setLastName(employees.getLastName());
            em.setEmail(employees.getEmail());
            em.setDepartment(employees.getDepartment());
            return employeeRepo.save(em);
        }).orElseThrow(() -> new EmployeeNotFoundException("Sorry, this employee could not be found"));
    }

    @Override
    public Employees getEmployeesById(Long id) {
        return employeeRepo.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Sorry, employee with this id"+ id +"could not be found"));
    }

    @Override
    public void deleteEmployees(Long id) {
        if(!employeeRepo.existsById(id)){
            throw new EmployeeNotFoundException("Sorry, employee not found");
        }
        employeeRepo.deleteById(id);
    }

    private boolean employeeAlreadyExists(String email){
        return employeeRepo.findByEmail(email).isPresent();
    }
}
