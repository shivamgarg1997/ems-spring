package com.emsspring.management;

import com.emsspring.exception.ResourceNotFoundException;
import com.emsspring.model.Department;

import java.util.List;

public interface DepartmentManagement {

    int deleteDepartment(String id) throws ResourceNotFoundException;

    Department addDepartment(Department department);

    List<Department> getAllDepartments();

    Department getDepartment(String id) throws ResourceNotFoundException;

}
