package com.emsspring.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "EMPLOYEE")
public class Employee extends AbstractModel implements Serializable {

    public Employee() {}
    public Employee(String id, String firstName, String lastName, String email) {
        super(id);
        //this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

//    @Id
//    @Column(name = "ID", unique = false, nullable = false)
//    private String id;

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "LASTMNAME")
    private String lastName;

    @Column(name = "EMAIL", unique = false, nullable = false)
    private String email;

    private Department department;

//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
