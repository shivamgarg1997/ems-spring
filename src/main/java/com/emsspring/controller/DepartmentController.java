package com.emsspring.controller;

import com.emsspring.management.DepartmentManagement;
import com.emsspring.model.Department;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentManagement departmentManagement;

    @DeleteMapping("/{id}")
    public ResponseEntity deleteDepartment(@NotBlank @PathVariable("id")String id){
        departmentManagement.deleteDepartment(id);
        return ResponseEntity.ok("department succesfully deleted");
    }

    @GetMapping("/{id}")
    public ResponseEntity getDepartment(@NotBlank @PathVariable("id")String id){
        return ResponseEntity.ok(departmentManagement.getDepartment(id));
    }

    @GetMapping("/list")
    public ResponseEntity getAllDepartments(){
        List<Department> departmentList = departmentManagement.getAllDepartments();
        return ResponseEntity.ok(departmentList);
    }

    @PostMapping("/")
    public ResponseEntity addEmployee(@Valid @RequestBody Department department){
        departmentManagement.addDepartment(department);
        return ResponseEntity.ok("okay");
    }
    @PostMapping("/{id}")
    public ResponseEntity updateDepartment(@NotBlank @PathVariable("id")String id, Department department){
        return null;
    }

}
