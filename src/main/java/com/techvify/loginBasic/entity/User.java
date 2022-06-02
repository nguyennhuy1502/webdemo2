package com.techvify.loginBasic.entity;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "account")
public class User {
    private static final Long serialVersionUID = 1L;//convert code sang bycode
    @Column(name = "AccountID")
    @Id
    @GeneratedValue
    private Short id;

    @Column(name = "Email", length = 50)
    private String email;

    @Column(name = "Username", length = 50, nullable = false, unique = true, updatable = false)
    private String username;

    @Column(name = "password", length = 800, nullable = false)
    private String password;

    @Column(name = "FirstName", length = 50)
    private String firstName;

    @OneToOne
    @JoinColumn(name = "departmentID",referencedColumnName = "departmentID")
    private Department department;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
