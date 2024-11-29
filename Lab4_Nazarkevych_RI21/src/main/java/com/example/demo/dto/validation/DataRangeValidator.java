package com.example.demo.dto.validation;


import com.example.demo.dto.BookingDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class DataRangeValidator implements ConstraintValidator<ValidDataRange, BookingDTO> {

    @Override
    public boolean isValid(BookingDTO bookingDTO, ConstraintValidatorContext context) {
        if (bookingDTO == null) {
            return true;
        }

        LocalDate startDate = bookingDTO.getStartDate();
        LocalDate endDate = bookingDTO.getEndDate();

        if (startDate == null || endDate == null) {
            return false;
        }

        if (startDate.isBefore(LocalDate.now())) {
            return false;
        }

        if (endDate.isBefore(startDate) || endDate.equals(startDate)) {
            return false;
        }

        return true;
    }
}
