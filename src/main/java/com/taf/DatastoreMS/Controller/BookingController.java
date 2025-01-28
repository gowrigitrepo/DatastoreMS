package com.taf.DatastoreMS.Controller;

import com.taf.DatastoreMS.Model.Booking;
import com.taf.DatastoreMS.Model.User;
import com.taf.DatastoreMS.Repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private final BookingRepository bookingRepository;

    public BookingController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveData(@RequestBody Booking booking) {
        bookingRepository.save(booking);
        return ResponseEntity.ok("Data saved successfully");
    }

    @GetMapping("fetch/{id}")
    public ResponseEntity<Optional<Booking>> fetchData(@PathVariable Long id) {
        Optional<Booking> booking = bookingRepository.findById(id);
        return ResponseEntity.ok(booking);
    }
}
