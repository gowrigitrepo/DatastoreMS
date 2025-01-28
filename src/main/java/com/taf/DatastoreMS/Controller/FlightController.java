package com.taf.DatastoreMS.Controller;

import com.taf.DatastoreMS.Model.Flight;
import com.taf.DatastoreMS.Repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/flight")
public class FlightController {
    @Autowired
    private final FlightRepository flightRepository;

    public FlightController(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveData(@RequestBody Flight flight) {
        flightRepository.save(flight);
        return ResponseEntity.ok("Data saved successfully");
    }

    @GetMapping("fetch/{id}")
    public ResponseEntity<Optional<Flight>> fetchData(@PathVariable Long id) {
        Optional<Flight> flight = flightRepository.findById(id);
        return ResponseEntity.ok(flight);
    }

}
