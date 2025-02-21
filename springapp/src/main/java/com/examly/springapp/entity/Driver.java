package com.examly.springapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Driver {
    @Id
    private Long id;
    private String name;
    private String licenseNumber;
    private String phone;
    private String assignedBus;
    public Driver() {
    }
    public Driver(Long id, String name, String licenseNumber, String phone, String assignedBus) {
        this.id = id;
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.phone = phone;
        this.assignedBus = assignedBus;
    }
    public long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLicenseNumber() {
        return licenseNumber;
    }
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAssignedBus() {
        return assignedBus;
    }
    public void setAssignedBus(String assignedBus) {
        this.assignedBus = assignedBus;
    }

}
