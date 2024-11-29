package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Facility {
    private Long id;
    private String name;
    private double expense;
    public Facility(Long id) {
        this.id = id;
    }
}
