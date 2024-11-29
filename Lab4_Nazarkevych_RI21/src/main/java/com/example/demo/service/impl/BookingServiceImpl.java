package com.example.demo.service.impl;
import com.example.demo.dto.BookingDTO;
import com.example.demo.dto.CottageDTO;
import com.example.demo.entity.Booking;
import com.example.demo.entity.Cottage;
import com.example.demo.entity.Facility;
import com.example.demo.exceptions.BookingNotFoundException;
import com.example.demo.exceptions.OverlappedCottageInBookingException;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.CottageRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final CottageRepository cottageRepository;
    private final UserRepository userRepository;

    public List<Booking> getAllBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        if( bookings.isEmpty())
        {
            throw new BookingNotFoundException("No bookings found");
        }
        return bookings;

    }

    @Override
    public Booking getBookingById(Long id) {

        return bookingRepository.findByBookingId(id);
    }

    public void createBooking(BookingDTO bookingDTO) {
        Long userId = bookingDTO.getUserId();
        Long cottageId = bookingDTO.getCottageId();

        // Check if the user already has a booking for the same cottage
        List<Booking> existingBookings = bookingRepository.findByUserIdAndCottageId(userId, cottageId);
        for (Booking booking : existingBookings) {
            if (booking.overlaps(bookingDTO.getStartDate(), bookingDTO.getEndDate())) {
                throw new OverlappedCottageInBookingException("User already has a booking that overlaps with the requested dates for this cottage.");
            }
        }

        // Check if the requested dates are available for the cottage
        List<Booking> cottageBookings = bookingRepository.findByCottageId(cottageId);
        for (Booking booking : cottageBookings) {
            if (booking.overlaps(bookingDTO.getStartDate(), bookingDTO.getEndDate())) {
                throw new OverlappedCottageInBookingException("The cottage is not available for the requested dates.");
            }
        }

        // Apply a 20% discount if the booking is during the low season (November or March)
        if (isLowSeason(bookingDTO.getStartDate())){
            System.out.println("Booking is in the low season. 20% discount applied.");
        }

        // Create and save the booking
        Booking booking = new Booking();
        booking.setId(bookingDTO.getId());
        booking.setCottageId(cottageId);
        booking.setUserId(userId);
        booking.setStartDate(bookingDTO.getStartDate());
        booking.setEndDate(bookingDTO.getEndDate());

        bookingRepository.save(booking);
    }

    public List<BookingDTO> checkAvailability(Long cottageId, String startDate, String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);

        List<Booking> cottageBookings = bookingRepository.findByCottageId(cottageId);
        List<BookingDTO> availableBookings = new ArrayList<>();

        for (Booking booking : cottageBookings) {
            if (!booking.overlaps(start, end)) {
                availableBookings.add(new BookingDTO(
                        booking.getId(),
                        booking.getCottageId(),
                        booking.getUserId(),
                        booking.getStartDate(),
                        booking.getEndDate()
                ));
            }
        }

        return availableBookings;
    }



    public boolean isLowSeason(LocalDate date) {
        int month = date.getMonthValue();
        return month == 11 || month == 3;
    }

    public double calculateTotalCost(Long bookingId, Long cottageId) {
        var cottage = cottageRepository.findById(cottageId).get();
        Booking booking = bookingRepository.findByBookingId(bookingId);
        return booking.calculateTotalCost(cottage);
    }
}