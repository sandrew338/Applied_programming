package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class Hotel {
    private Long id;
    private String name;
    private String location;
    private List<Facility> facilities = new ArrayList<>();
    private List<Cottage> cottages = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();
    private double income;
    private double expenses;

    public Hotel(String hotelName) {

    }


    public void addFacility(Facility facility) {
        facilities.add(facility);
    }

    public void addCottage(Cottage cottage) {
        cottages.add(cottage);
    }

//    public void addBooking(Booking booking) {
//        bookings.add(booking);
//        income += booking.calculateTotalCost();
//    }

    public double getProfit() {
        return income - expenses;
    }
}
