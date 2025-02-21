package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.examly.springapp.entity.Bus;
import com.examly.springapp.service.BusService;

import java.util.List;

@RestController
@RequestMapping("api/buses")
public class BusController {

    @Autowired
    private BusService busService;

    // Get all buses
    @GetMapping
    public List<Bus> getAllBuses() {
        return busService.getAllBuses();
    }

    // Get bus by ID
    @GetMapping("/{id}")
    public ResponseEntity<Bus> getBusById(@PathVariable Long id) {
        Bus bus = busService.getBusById(id);
        return bus != null ? ResponseEntity.ok(bus) : ResponseEntity.notFound().build();
    }

    // Create a new bus
    @PostMapping
    public Bus createBus(@RequestBody Bus bus) {
        return busService.createBus(bus);
    }
    @GetMapping("/sorted")
    public List<Bus> getSortedBuses(@RequestParam(defaultValue = "id") String sortBy) {
        return busService.getSortedBuses(sortBy);
    }
    @DeleteMapping("/{id}")
public ResponseEntity<Void> deleteBus(@PathVariable Long id) {
    if (!busService.existsById(id)) {
        return ResponseEntity.notFound().build(); // 404 Not Found if bus does not exist
    }
    busService.deleteBus(id);
    return ResponseEntity.noContent().build(); // 204 No Content if deletion is successful
}

}
