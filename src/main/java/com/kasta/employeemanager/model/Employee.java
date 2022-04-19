package com.kasta.employeemanager.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
@Data
@Entity
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Long id;
    private String employeeName;
    private String email;
    private String jobTitle;
    private String phone;
    private String imageURL;
    @Column(nullable = false,updatable = false)
    private String employeeCode;
}
