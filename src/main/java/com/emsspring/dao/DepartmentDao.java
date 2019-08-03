package com.emsspring.dao;

import com.emsspring.model.Department;

import java.util.List;

public interface DepartmentDao {

    Department getDepartment(String id);

    Department addDepartment(Department department);

    int deleteDepartment(String id);

    int updateDepartment(Department department);

    List<Department> getAllDepartments();

}
