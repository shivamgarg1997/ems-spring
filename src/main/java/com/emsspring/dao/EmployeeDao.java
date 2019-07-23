package com.emsspring.dao;

import com.emsspring.model.Employee;

public interface EmployeeDao {

    Employee getEmployee(String id);

    Employee addEmployee(Employee employee);
}
