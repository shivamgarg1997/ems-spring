package com.emsspring.dao.impl;

import com.emsspring.dao.EmployeeDao;
import com.emsspring.model.Employee;
import com.emsspring.abstractaudit.*;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class DefaultEmployeeDao extends AbstractDao implements EmployeeDao {
    @Override
    public Employee getEmployee(String id) {

        CriteriaBuilder cb = getCriteriaBuilder();
        CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
        Root<Employee> root  = query.from(Employee.class);
        query.select(root);
        query.where(cb.equal(root.get("id"),id));
        return getSession().createQuery(query).getSingleResult();
    }

    @Override
    public List<Employee> getAllEmployees() {
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = cb.createQuery(Employee.class);
        Root<Employee> root = criteriaQuery.from(Employee.class);
        criteriaQuery.select(root);
        Query<Employee> query = getSession().createQuery(criteriaQuery);
        return query.getResultList();
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
    public int updateEmployee(Employee employee) {
        return 0;
    }
}
