package com.emsspring.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "EMPLOYEE")
@Data
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "modifieddAt"},
        allowGetters = true)
public class Employee  implements Serializable {

    public Employee() {}

    public Employee(String id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Id
    @Column(name = "ID", unique = false, nullable = false)
    private String id;

    @NotBlank
    @Column(name = "FIRSTNAME")
    @Pattern(regexp = "[^a-zA-Z]+",message = "name should only contain letter")
    private String firstName;

    @NotBlank
    @Column(name = "LASTMNAME")
    @Pattern(regexp = "[^a-zA-Z]+",message = "name should only contain letter")
    private String lastName;

    @Column(name = "EMAIL", unique = false, nullable = false)
    @Email(message = "Email is not valid")
    private String email;

    @Min(value = 18,message = "Age cant be smaller than 18")
    private int age;

    @ManyToOne
    private Department department;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedAt;
}
