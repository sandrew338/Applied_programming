package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class Cottage {
    private Long id;
    private String category;//lux, standart or super plus
    private double basePrice;
    private int maxGuests;
    private List<Facility> facilities = new ArrayList<>();
    private Hotel hotel;

    public void addFacility(Facility facility) {
        facilities.add(facility);
    }
}