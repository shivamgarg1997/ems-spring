package com.emsspring.controller;

import com.emsspring.management.EmployeeManagement;
import com.emsspring.model.Employee;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeManagement employeeManagement;

    @GetMapping("/list")
    public ResponseEntity getEmployees(){
        List<Employee> employeesList = employeeManagement.getAllEmployees();
        return ResponseEntity.ok(employeesList);
    }

    @GetMapping("/{id}")
    public ResponseEntity getEmployee(@NotBlank @PathVariable("id") String id){
        Employee employee = employeeManagement.getEmployee(id);
        return ResponseEntity.ok(employee);
    }

    @PostMapping("/")
    public ResponseEntity addEmployee(@Valid @RequestBody Employee employee){
        employeeManagement.addEmployee(employee);
        return ResponseEntity.ok("okay");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEmployee(@NotBlank @PathVariable("id") String id) {
        return ResponseEntity.ok(deleteEmployee(id));
    }
}
