package com.emsspring.dao.impl;

import com.emsspring.abstractaudit.AbstractDao;
import com.emsspring.dao.DepartmentDao;
import com.emsspring.model.Department;
import com.emsspring.model.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

@Repository
@Transactional
public class DefaultDepartmentDao extends AbstractDao<Department> implements DepartmentDao {

    DefaultDepartmentDao(){
          super(Department.class);
    }

    @Override
    public void addDepartment(Department department) {
        save(department);
    }

    @Override
    public void deleteDepartment(String id) {
        CriteriaBuilder cb = getCriteriaBuilder();
        CriteriaDelete<Department> delete = cb.createCriteriaDelete(Department.class);
        Root<Department> root = delete.from(Department.class);
        delete.where(cb.equal(root.get("id"),id));
        getSession().createQuery(delete).executeUpdate();
    }
}
