package com.emsspring.management.impl;

import com.emsspring.dao.DepartmentDao;
import com.emsspring.dao.impl.DefaultDepartmentDao;
import com.emsspring.management.DepartmentManagement;
import com.emsspring.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DefaultDepartmentManagement implements DepartmentManagement {

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public int deleteDepartment(String id) {
        return departmentDao.deleteDepartment(id);
    }

    @Override
    public Department addDepartment(Department department) {
        department.setId( UUID.randomUUID().toString().replace("-", ""));
        return departmentDao.addDepartment(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentDao.getAllDepartments();
    }

    @Override
    public Department getDepartment(String id) {
        return departmentDao.getDepartment(id);
    }


}
