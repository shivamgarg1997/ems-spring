package com.emsspring.model;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

//@Entity
public class AbstractModel {

    AbstractModel(){}

    AbstractModel(String id){
        this.id = id;
    }

    @Id
    @Column(name = "id", nullable = false, unique = true)
    private String id;

    @Column(name = "CREATED_ON")
    private long createdOn;

    @Column(name = "MODIFIED_ON")
    private long modifiedOn;

    public long getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(long createdOn) {
        this.createdOn = createdOn;
    }

    public long getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(long modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
