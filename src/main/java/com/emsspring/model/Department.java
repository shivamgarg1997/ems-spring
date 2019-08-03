package com.emsspring.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import javax.persistence.CascadeType;
import java.util.Set;

@Entity
@Table(name = "DEPARTMENT")
@Data
public class Department  implements Serializable {

    Department(){}

    Department(String id,String title){
        this.id = id;
        this.title = title;
    }

    @Id
    @Column(name = "ID", nullable = false , unique = true)
    private String id;

    @Column(name = "TITLE" ,nullable = false, unique = true)
    private String title;

    @OneToMany
    @JoinTable(name = "EMPLOYEE-DEPARTMENT",
               joinColumns = {@JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "ID")},
               inverseJoinColumns = {@JoinColumn(name = "EMPLOYEE_ID" ,referencedColumnName = "ID")})
    Set<Employee> employeeList;

    public Set<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(Set<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
