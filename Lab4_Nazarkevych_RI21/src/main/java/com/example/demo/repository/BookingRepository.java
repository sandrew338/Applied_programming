package com.example.demo.repository;

import com.example.demo.entity.Booking;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BookingRepository {

    private final List<Booking> bookings = new ArrayList<>();

    public List<Booking> findByUserIdAndCottageId(Long userId, Long cottageId) {
        return bookings.stream()
                .filter(booking -> booking.getUserId().equals(userId) && booking.getCottageId().equals(cottageId))
                .collect(Collectors.toList());
    }

    public List<Booking> findByCottageId(Long cottageId) {
        return bookings.stream()
                .filter(booking -> booking.getCottageId().equals(cottageId))
                .collect(Collectors.toList());
    }

    public void save(Booking booking) {
        bookings.add(booking);
    }

    public void deleteById(Long id) {
        bookings.removeIf(booking -> booking.getId().equals(id));
    }

    public List<Booking> findAll() {
        return bookings;
    }

    public Booking findByBookingId(Long id) {
        return bookings.stream().filter(booking -> booking.getId().equals(id)).findFirst().get();
    }
}
