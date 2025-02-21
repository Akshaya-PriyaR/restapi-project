package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.entity.Driver;
import com.examly.springapp.repository.DriverRepository;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    // Get all drivers
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    // Get driver by ID
    public Driver getDriverById(long id) {
        return driverRepository.findById(id).orElse(null);
    }

    // Create a new driver
    public Driver createDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    // Update an existing driver
    // Update an existing driver
public Driver updateDriver(long id, Driver driverDetails) {
    return driverRepository.findById(id).map(driver -> {
        driver.setName(driverDetails.getName());
        driver.setLicenseNumber(driverDetails.getLicenseNumber());
        driver.setPhone(driverDetails.getPhone());
        driver.setAssignedBus(driverDetails.getAssignedBus());
        return driverRepository.save(driver);
    }).orElse(null);
}


    public boolean existsById(long id) {
        return driverRepository.existsById(id);
    }

    // Delete a driver
    public void deleteDriver(Long id) {

        driverRepository.deleteById(id);
    }
}
