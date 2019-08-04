package com.emsspring.management;

import com.emsspring.exception.ResourceNotFoundException;
import com.emsspring.model.Employee;

import java.util.List;

public interface EmployeeManagement {

    List<Employee> getAllEmployees();

    Employee getEmployee(String id) throws ResourceNotFoundException;

    Employee addEmployee(Employee employee);

    void deleteEmployee(String id) throws ResourceNotFoundException;

}
