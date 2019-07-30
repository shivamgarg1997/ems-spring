package com.emsspring.management.impl;

import com.emsspring.dao.DepartmentDao;
import com.emsspring.dao.impl.DefaultDepartmentDao;
import com.emsspring.management.DepartmentManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultDepartmentManagement implements DepartmentManagement {

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public void deleteDepartment(String id) {
        departmentDao.deleteDepartment(id);
    }
}
