package com.example.demo.dto;

import com.example.demo.dto.validation.ValidDataRange;
import com.example.demo.entity.Hotel;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CottageDTO {
    private Long id;

    @NotNull(message = "Category must not be null")
    private String category; // "lux", "standart" або "super plus"

    @NotNull(message = "Base price must not be null")
    private double basePrice;

    @NotNull(message = "Max guests must not be null")
    private int maxGuests;

    private List<Long> facilityIds;
    // private Hotel hotel;
}