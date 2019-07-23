package com.emsspring.controller;

import com.emsspring.management.EmployeeManagement;
import com.emsspring.model.Employee;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeManagement employeeManagement;

//    @GetMapping("/list")
//    public ResponseEntity getEmployees(){
//
//    }

    @GetMapping("/{id}")
    public ResponseEntity getEmployee(@PathVariable("id") String id){
        if(StringUtils.isBlank(id)){

        }
        Employee employee = employeeManagement.getEmployee(id);
        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }

    @PostMapping("/")
    public ResponseEntity addEmployee(@RequestBody Employee employee){
        employeeManagement.addEmployee(employee);
        return ResponseEntity.status(HttpStatus.OK).body("okay");
    }

}