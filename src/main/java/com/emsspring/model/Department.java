package com.emsspring.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "DEPARTMENT")
@Data
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "modifieddAt"},
        allowGetters = true)
public class Department  implements Serializable {

    Department(){}

    Department(String id,String title){
        this.id = id;
        this.title = title;
    }

    @Id
    @Column(name = "ID", nullable = false , unique = true)
    private String id;

    @NotBlank
    @Column(name = "TITLE" ,nullable = false, unique = true)
    private String title;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedAt;

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
