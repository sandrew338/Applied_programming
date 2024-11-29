package com.example.demo.dto;

import com.example.demo.dto.validation.ValidDataRange;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HotelDTO {
    private Long id;
    private String name;
    private double totalIncome;
    private double totalExpenses;
    private List<Long> cottageIds;
    private List<Long> facilityIds;
}
