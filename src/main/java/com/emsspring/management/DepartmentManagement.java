package com.emsspring.management;

import com.emsspring.model.Department;

import java.util.List;

public interface DepartmentManagement {

    int deleteDepartment(String id);

    List<Department> getAllDepartments();

    Department getDepartment(String id);

}
