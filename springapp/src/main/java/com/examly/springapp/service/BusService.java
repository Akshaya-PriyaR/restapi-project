package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import com.examly.springapp.entity.Bus;
import com.examly.springapp.repository.BusRepository;

@Service
public class BusService {

    @Autowired
    private BusRepository busRepository;

    // Get all buses
    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }
    public List<Bus> getSortedBuses(String sortBy) {
        return busRepository.findAll(Sort.by(sortBy)); // Sorting dynamically
    }

    // Get bus by ID
    public Bus getBusById(long id) {
        return busRepository.findById(id).orElse(null);
    }

    // Create a new bus
    public Bus createBus(Bus bus) {
        return busRepository.save(bus);
    }

    // Update an existing bus
    public Bus updateBus(long id, Bus busDetails) {
        if (busRepository.existsById(id)) {
            Bus bus = busRepository.findById(id).orElse(null);

            if (bus != null) {
                bus.setBusNumber(busDetails.getBusNumber());
                bus.setRoute(busDetails.getRoute());
                bus.setCapacity(busDetails.getCapacity());
                bus.setDriverName(busDetails.getDriverName());
                return busRepository.save(bus);
            }
        }

        System.out.println("Bus not found");
        return null;
    }

    // Delete a bus
    public void deleteBus(Long id) {
        if (id == null || !busRepository.existsById(id)) {
            System.out.println("Bus not found");
            return;
        }

        busRepository.deleteById(id);
    }
    public boolean existsById(Long id) {
        return busRepository.existsById(id);
    }
    
}
