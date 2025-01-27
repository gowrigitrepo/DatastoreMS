package com.taf.DatastoreMS.Controller;

import com.taf.DatastoreMS.Model.Flight;
import com.taf.DatastoreMS.Repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


public class FlightController {
    @Autowired
    private final FlightRepository flightRepository;

    public FlightController(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> getAllFights() {
        return flightRepository.findAll();
    }

    public Optional<Flight> getFlightById(Long flightId) {
        return flightRepository.findById(flightId);
    }

    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public Flight updateFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public void deleteFlightById(Long flightId) {
        flightRepository.deleteById(flightId);
    }

}
