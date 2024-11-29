
package com.example.demo.service;

import com.example.demo.dto.BookingDTO;
import com.example.demo.dto.CottageDTO;
import com.example.demo.entity.Booking;

import java.time.LocalDate;
import java.util.List;

public interface BookingService {

    public List<Booking> getAllBookings();
    public void createBooking(BookingDTO bookingDTO) ;
    public Booking getBookingById(Long id);

    public List<BookingDTO> checkAvailability(Long cottageId, String startDate, String endDate);
    public boolean isLowSeason(LocalDate date);
    public double calculateTotalCost(Long bookingId, Long cottageId);
    }
