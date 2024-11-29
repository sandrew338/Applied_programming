package com.example.demo.dto;
import com.example.demo.dto.validation.ValidDataRange;
import jakarta.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ValidDataRange
public class BookingDTO {
    private Long id;

    @NotNull(message = "Cottage ID must not be null")
    private Long cottageId;

    @NotNull(message = "User ID must not be null")
    private Long userId;

    @NotNull(message = "Start date must not be null")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @NotNull(message = "End date must not be null")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    // геттери та сеттери
}
