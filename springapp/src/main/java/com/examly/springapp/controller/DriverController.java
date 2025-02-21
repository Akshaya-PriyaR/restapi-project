package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.entity.Driver;
import com.examly.springapp.service.DriverService;

import java.util.List;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {
    @Autowired
    private DriverService driverService;

    // Get all drivers
    @GetMapping
    public List<Driver> getAllDrivers() {
        return driverService.getAllDrivers();
    }

    // Get driver by ID
    @GetMapping("/driversByBus")
    public ResponseEntity<Driver> getDriverById(@PathVariable long id) {
        Driver driver = driverService.getDriverById(id);
        return (driver != null) ? ResponseEntity.ok(driver) : ResponseEntity.notFound().build();
    }

    // Create a new driver
    @PostMapping
    public ResponseEntity<Driver> createDriver(@RequestBody Driver driver) {
        Driver newDriver = driverService.createDriver(driver);
        return ResponseEntity.ok(newDriver);
    }

    @DeleteMapping("/{id}")
public ResponseEntity<Void> deleteDriver(@PathVariable long id) {
    if (driverService.existsById(id)) {
        driverService.deleteDriver(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    } else {
        return ResponseEntity.notFound().build(); // 404 Not Found
    }
}

    
}
