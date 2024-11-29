package com.example.demo.controller;

import com.example.demo.dto.BookingDTO;
import com.example.demo.dto.validation.ValidDataRange;
import com.example.demo.entity.Booking;
import com.example.demo.exceptions.BookingNotFoundException;
import com.example.demo.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/bookings")
public class BookingController {

    private final BookingService bookingService;
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }
    @GetMapping
    public ResponseEntity<String> getAllBookings() {
        try {
            List<Booking> bookings = bookingService.getAllBookings();
            return ResponseEntity.ok(bookings.toString());
        } catch (BookingNotFoundException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }

    }

    @PostMapping("/create")
    public ResponseEntity<String> createBooking(@Valid @RequestBody BookingDTO bookingDTO) {
        try {
            bookingService.createBooking(bookingDTO);
            return ResponseEntity.ok("Booking created successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @GetMapping("/available/{cottageId}")
    public ResponseEntity<List<BookingDTO>> checkCottageAvailability(@PathVariable Long cottageId,
                                                                     @RequestParam String startDate,
                                                                     @RequestParam String endDate) {
        List<BookingDTO> availableBookings = bookingService.checkAvailability(cottageId, startDate, endDate);
        return ResponseEntity.ok(availableBookings);
    }

    @GetMapping("/incomes/{bookingId}/{cottageId}")
    public HttpEntity<Double> getIncomesForBooking(@PathVariable Long bookingId, @PathVariable Long cottageId) {

        return ResponseEntity.ok(bookingService.calculateTotalCost(bookingId, cottageId));
    }
}
