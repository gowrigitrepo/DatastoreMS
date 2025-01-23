package com.taf.DatastoreMS.Service.Interface;

import com.taf.DatastoreMS.Model.Flight;

import java.util.List;
import java.util.Optional;

public interface FlightService {
    List<Flight> getAllFights();
    Optional<Flight> getFlightById(Long flightId);
    Flight addFlight(Flight flight);
    Flight updateFlight(Flight flight);
    void deleteFlightById(Long flightId);
}
