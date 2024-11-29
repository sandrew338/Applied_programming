package com.example.demo.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "No cottages.")
public class CottageNotFoundException extends RuntimeException {
  public CottageNotFoundException(String message) {
    super(message);
  }
}
