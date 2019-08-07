package com.emsspring.dao.impl;

import com.emsspring.dao.EmployeeDao;
import com.emsspring.exception.ResourceNotFoundException;
import com.emsspring.model.Employee;
import com.emsspring.abstractaudit.*;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class DefaultEmployeeDao extends AbstractDao implements EmployeeDao {
    @Override
    public Employee getEmployee(String id) throws ResourceNotFoundException {

        CriteriaBuilder cb = getCriteriaBuilder();
        CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
        Root<Employee> root  = query.from(Employee.class);
        query.select(root);
        query.where(cb.equal(root.get("id"),id));
        Employee emp =  getSession().createQuery(query).getSingleResult();
        Optional<Employee> opt = Optional.ofNullable(emp);
        if(opt.isPresent()){
            return opt.get();
        } else {
            throw new ResourceNotFoundException("Employee","id",id);
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = cb.createQuery(Employee.class);
        Root<Employee> root = criteriaQuery.from(Employee.class);
        criteriaQuery.select(root);
        Query<Employee> query = getSession().createQuery(criteriaQuery);
        List<Employee> list = query.getResultList();
        list.sort(Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getAge));
        return list;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        save(employee);
        return getEmployee(employee.getId());
    }

    @Override
    public int deleteEmployee(String id) {
        CriteriaBuilder cb = getCriteriaBuilder();
        CriteriaDelete<Employee> delete = cb.createCriteriaDelete(Employee.class);
        Root<Employee> root = delete.from(Employee.class);
        delete.where(cb.equal(root.get("id"),id));
        return getSession().createQuery(delete).executeUpdate();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        getSession().update(employee);
        return getEmployee(employee.getId());
    }
}
