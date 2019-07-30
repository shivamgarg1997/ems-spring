package com.emsspring.controller;

import com.emsspring.management.DepartmentManagement;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentManagement departmentManagement;

    @DeleteMapping("/{id}")
    public ResponseEntity deleteDepartment(@PathVariable("id")String id){
        if(StringUtils.isBlank(id)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("provide department ID to be deleted");
        }
        departmentManagement.deleteDepartment(id);
        return ResponseEntity.status(200).body("department succesfully deleted");
    }
}
