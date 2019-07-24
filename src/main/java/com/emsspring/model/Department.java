package com.emsspring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "DEPARTMENT")
public class Department extends AbstractModel implements Serializable {

    Department(){}

    Department(String id,String title){
        super(id);
        this.title = title;
    }

//    @Id
//    @Column(name = "ID", nullable = false , unique = true)
//    private String id;

    @Column(name = "TITLE" ,nullable = false, unique = true)
    private String title;

//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
