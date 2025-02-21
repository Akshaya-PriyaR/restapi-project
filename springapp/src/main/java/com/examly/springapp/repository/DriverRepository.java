package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.examly.springapp.entity.Driver;
import java.util.List;

public interface DriverRepository extends JpaRepository<Driver, Long> {

    // Retrieve all drivers
    @Query("SELECT d FROM Driver d")
    List<Driver> findAllDrivers();

    // Retrieve a driver by ID
    @Query("SELECT d FROM Driver d WHERE d.id = :id")
    Driver findDriverById(@Param("id") Long id);

    // Retrieve drivers by name
    @Query("SELECT d FROM Driver d WHERE d.name = :name")
    List<Driver> findDriversByName(@Param("name") String name);

    // Update driver's contact number by ID
    @Transactional
    @Modifying
    @Query("UPDATE Driver d SET d.phone = :phone WHERE d.id = :id")
    void updateDriverContact(@Param("id") Long id, @Param("phone") String phone);

    // Delete a driver by ID
    @Transactional
    @Modifying
    @Query("DELETE FROM Driver d WHERE d.id = :id")
    void deleteDriverById(@Param("id") Long id);
}
