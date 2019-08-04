package com.emsspring.management.impl;

import com.emsspring.dao.EmployeeDao;
import com.emsspring.dao.impl.DefaultEmployeeDao;
import com.emsspring.exception.ResourceNotFoundException;
import com.emsspring.management.EmployeeManagement;
import com.emsspring.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DefaultEmployeeManagement implements EmployeeManagement {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    @Override
    public Employee getEmployee(String id) throws ResourceNotFoundException {
        return employeeDao.getEmployee(id);
    }

    @Override
    public Employee addEmployee(Employee employee) {
        employee.setId( UUID.randomUUID().toString().replace("-", ""));
        return employeeDao.addEmployee(employee);
    }

    @Override
    public void deleteEmployee(String id) throws ResourceNotFoundException   {
       employeeDao.deleteEmployee(id);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeDao.updateEmployee(employee);
    }
}
