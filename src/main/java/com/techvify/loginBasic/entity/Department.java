package com.techvify.loginBasic.entity;

import javax.persistence.*;

@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue
    @Column(name = "departmentID")
    private Short departmentID;

    @Column(name = "departmentName", length = 50, nullable = false, unique = true, updatable = false)
    private String departmentName;

    public Department() {
    }

    public Department(Short departmentID, String departmentName) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Short departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
