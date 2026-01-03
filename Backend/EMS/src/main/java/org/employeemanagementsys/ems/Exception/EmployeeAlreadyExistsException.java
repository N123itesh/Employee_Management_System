package org.employeemanagementsys.ems.Exception;

public class EmployeeAlreadyExistsException extends RuntimeException {
    public EmployeeAlreadyExistsException(String message) {
        super(message);
    }
}
