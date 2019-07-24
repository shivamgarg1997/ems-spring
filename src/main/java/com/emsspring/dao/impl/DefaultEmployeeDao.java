package com.emsspring.dao.impl;

import com.emsspring.dao.EmployeeDao;
import com.emsspring.model.Employee;
import com.emsspring.abstractaudit.*;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class DefaultEmployeeDao extends AbstractAuditDao implements EmployeeDao {
    @Override
    public Employee getEmployee(String id) {
        return null;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        save(employee);
        return null;
    }
}
