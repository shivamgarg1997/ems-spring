package com.emsspring.dao.impl;

import com.emsspring.abstractaudit.AbstractDao;
import com.emsspring.dao.DepartmentDao;
import com.emsspring.model.Department;
import com.emsspring.model.Employee;
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
public class DefaultDepartmentDao extends AbstractDao<Department> implements DepartmentDao {

    @Override
    public Department getDepartment(String id) {
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<Department> criteriaQuery = cb.createQuery(Department.class);
        Root<Department> root = criteriaQuery.from(Department.class);
        criteriaQuery.select(root);
        criteriaQuery.where(cb.equal(root.get("id"), id));
        Query<Department> query = getSession().createQuery(criteriaQuery);
        return query.getSingleResult();
    }

    @Override
    public Department addDepartment(Department department) {
        String id = department.getId();
        save(department);
        return getDepartment(id);
    }

    @Override
    public int deleteDepartment(String id) {
        CriteriaBuilder cb = getCriteriaBuilder();
        CriteriaDelete<Department> delete = cb.createCriteriaDelete(Department.class);
        Root<Department> root = delete.from(Department.class);
        delete.where(cb.equal(root.get("id"),id));
        return getSession().createQuery(delete).executeUpdate();
    }

    @Override
    public List<Department> getAllDepartments() {
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<Department> criteriaQuery = cb.createQuery(Department.class);
        Root<Department> root = criteriaQuery.from(Department.class);
        criteriaQuery.select(root);
        Query<Department> query = getSession().createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public int updateDepartment(Department department) {
        return 0;
    }

}
