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

    @GetMapping("/list")
    public ResponseEntity getEmployees(){
        List<Employee> employeesList = employeeManagement.getAllEmployees();
        return ResponseEntity.ok(employeesList);
    }

    @GetMapping("/{id}")
    public ResponseEntity getEmployee(@PathVariable("id") String id){
        if(StringUtils.isBlank(id)){
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Employee Id was not found");
        }
        Employee employee = employeeManagement.getEmployee(id);
        return ResponseEntity.ok(employee);
    }

    @PostMapping("/")
    public ResponseEntity addEmployee(@RequestBody Employee employee){
        employeeManagement.addEmployee(employee);
        return ResponseEntity.ok("okay");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEmployee(@PathVariable("id") String id) {
        try {
            employeeManagement.deleteEmployee(id);
            return ResponseEntity.ok("Employee successfully deleted");
        } catch(Exception e) {
            return ResponseEntity.status(200).body(e.toString());
        }
    }
}
