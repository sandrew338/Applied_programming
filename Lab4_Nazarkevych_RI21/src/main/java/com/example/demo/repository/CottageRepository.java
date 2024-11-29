package com.example.demo.repository;

import com.example.demo.entity.Cottage;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CottageRepository {
    private List<Cottage> cottages = new ArrayList<>();

    public List<Cottage> findAll() {
        return cottages;
    }

    public Optional<Cottage> findById(Long id) {
        return cottages.stream().filter(cottage -> cottage.getId().equals(id)).findFirst();
    }

    public Cottage save(Cottage cottage) {
        cottages.add(cottage);
        return cottage;
    }

    public Optional<Cottage> update(Long id, Cottage cottage) {
        Optional<Cottage> existingCottage = findById(id);
        existingCottage.ifPresent(c -> {
            c.setCategory(cottage.getCategory());
            c.setBasePrice(cottage.getBasePrice());
            c.setMaxGuests(cottage.getMaxGuests());
            c.setFacilities(cottage.getFacilities());
            c.setHotel(cottage.getHotel());
        });
        return existingCottage;
    }

    public boolean delete(Long id) {
        return cottages.removeIf(cottage -> cottage.getId().equals(id));
    }
}
