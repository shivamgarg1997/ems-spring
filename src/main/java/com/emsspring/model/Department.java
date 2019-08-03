package com.emsspring.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

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

    List<Employee> employeeList;

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
