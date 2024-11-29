package com.example.demo.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Client has already booked this accommodation")

public class OverlappedCottageInBookingException extends RuntimeException {
    public OverlappedCottageInBookingException(String message) {
        super(message);
    }
}
