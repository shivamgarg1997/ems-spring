package com.emsspring.dao.impl;

import com.emsspring.dao.EmployeeDao;
import com.emsspring.model.Employee;
import com.emsspring.abstractaudit.*;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

@Repository
@Transactional
public class DefaultEmployeeDao extends AbstractDao<Employee> implements EmployeeDao {

    DefaultEmployeeDao(){
        super(Employee.class);
    }

    @Override
    public Employee getEmployee(String id) {
        return null;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        save(employee);
        return null;
    }

    @Override
    public void deleteEmployee(String id) {
        CriteriaBuilder cb = getCriteriaBuilder();
        CriteriaDelete<Employee> delete = cb.createCriteriaDelete(Employee.class);
        Root<Employee> root = delete.from(Employee.class);
        delete.where(cb.equal(root.get("id"),id));
        getSession().createQuery(delete).executeUpdate();
    }
}
