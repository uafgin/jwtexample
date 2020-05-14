package com.jwt.jwtexample.model;

import java.util.Date;

public class JwtUser {
    private long id;
    private String contractId;
    private String firstName;
    private String lastName;
    private Date eat;
    private String role;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public Date getEat() {
        return eat;
    }

    public void setEat(Date eat) {
        this.eat = eat;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

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
}
