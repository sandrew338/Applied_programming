package com.example.demo.entity;

import com.example.demo.repository.CottageRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    private Long id;
    private Long cottageId;
    private Long userId;
    private LocalDate startDate;
    private LocalDate endDate;


    public boolean overlaps(LocalDate start, LocalDate end) {
        return (start.isBefore(this.endDate) && end.isAfter(this.startDate));
    }



    public double calculateTotalCost(Cottage cottage) {
        boolean lowSeason = startDate.getMonthValue() == 11 || startDate.getMonthValue() == 3;
        double discount = lowSeason ? 0.8 : 1.0;
        return cottage.getBasePrice() * discount;
    }
}
