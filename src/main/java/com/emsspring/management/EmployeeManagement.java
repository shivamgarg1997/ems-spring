package com.emsspring.management;

import com.emsspring.model.Employee;

import java.util.List;

public interface EmployeeManagement {

    List<Employee> getAllEmployees();

    Employee getEmployee(String id);

    Employee addEmployee(Employee employee);

    int deleteEmployee(String id);

}
