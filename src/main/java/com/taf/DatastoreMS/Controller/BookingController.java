package com.taf.DatastoreMS.Controller;

import com.taf.DatastoreMS.Model.Booking;
import com.taf.DatastoreMS.Repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class BookingController {
    @Autowired
    private final BookingRepository bookingRepository;

    public BookingController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> getAllBookingsByUserId() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Long bookingId) {
        return bookingRepository.findById(bookingId).orElse(null);
    }

    public Booking addBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public void deleteBookingById(Long bookingId) {
        bookingRepository.deleteById(bookingId);
    }
}
