package com.emsspring.controller;

import com.emsspring.management.DepartmentManagement;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return ResponseEntity.ok("department succesfully deleted");
    }

    @GetMapping("/{id}")
    public ResponseEntity getDepartment(@PathVariable("id")String id){
        if(StringUtils.isBlank(id)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("provide department ID to be deleted");
        }
        return ResponseEntity.ok(departmentManagement.getDepartment(id));
    }
}
