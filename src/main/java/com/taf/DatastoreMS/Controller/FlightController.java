package com.taf.DatastoreMS.Controller;

import com.taf.DatastoreMS.Model.Flight;
import com.taf.DatastoreMS.Service.FlightServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightServiceImpl flightServiceImpl;

    @GetMapping
    public List<Flight> getAllFlights() {
        return flightServiceImpl.getAllFights();
    }

    @GetMapping("/{flightId}")
    public Optional<Flight> getFlightById(@PathVariable Long flightId) {
        return flightServiceImpl.getFlightById(flightId);
    }

    @PostMapping
    public Flight addFlight(@RequestBody Flight flight) {
        return flightServiceImpl.addFlight(flight);
    }

    @PutMapping("/{flightId}")
    public Flight updateFlight(@PathVariable Long flightId,@RequestBody Flight flight) {
        return flightServiceImpl.updateFlight(flight);
    }

    @DeleteMapping("/{flightId}")
    public void deleteFlightById(@PathVariable Long flightId) {
        flightServiceImpl.deleteFlightById(flightId);
    }

}
