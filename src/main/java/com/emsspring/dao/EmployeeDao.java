package com.emsspring.dao;

import com.emsspring.model.Department;
import com.emsspring.model.Employee;

import java.util.List;

public interface EmployeeDao {

    Employee getEmployee(String id);

    List<Employee> getAllEmployees();

    Employee addEmployee(Employee employee);

    int deleteEmployee(String id);

    int updateEmployee(Employee employee);
}
