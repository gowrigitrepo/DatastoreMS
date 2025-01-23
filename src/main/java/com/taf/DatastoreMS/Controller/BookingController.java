package com.taf.DatastoreMS.Controller;

import com.taf.DatastoreMS.Model.Booking;
import com.taf.DatastoreMS.Service.BookingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    private BookingServiceImpl bookingServiceImpl;

    @GetMapping("/users/{userId}")
    public List<Booking> getAllBookingsByUserId() {
        return bookingServiceImpl.getAllBookingsByUserId();
    }

    @GetMapping("/{bookingId}")
    public Booking getBookingById(@PathVariable Long bookingId) {
        return bookingServiceImpl.getBookingById(bookingId);
    }

    @PostMapping
    public Booking addBooking(@RequestBody Booking booking) {
        return bookingServiceImpl.addBooking(booking);
    }

    @DeleteMapping("/{bookingId}")
    public ResponseEntity<String> deleteBookingById(@PathVariable Long bookingId) {
        if(!bookingServiceImpl.getBookingById(bookingId).getId().equals(0L)) {
            bookingServiceImpl.deleteBookingById(bookingId);
            return ResponseEntity.ok("Booking deleted successfully.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Booking not found.");
    }
}
