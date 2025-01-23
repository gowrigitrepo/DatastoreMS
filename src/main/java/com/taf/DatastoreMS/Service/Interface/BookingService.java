package com.taf.DatastoreMS.Service.Interface;

import com.taf.DatastoreMS.Model.Booking;

import java.util.List;

public interface BookingService {
    List<Booking> getAllBookingsByUserId();
    Booking getBookingById(Long bookingId);
    Booking addBooking(Booking booking);
    void deleteBookingById(Long bookingId);
}
