package com.example.demo.repository;

import com.example.demo.entity.Facility;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class FacilityRepository {

    private final List<Facility> facilities = new ArrayList<>();

    public List<Facility> findAll() {
        return facilities;
    }

    public Optional<Facility> findById(Long id) {
        return facilities.stream().filter(facility -> facility.getId().equals(id)).findFirst();
    }

    public Facility save(Facility facility) {
        facilities.add(facility);
        return facility;
    }

    public void deleteById(Long id) {
        facilities.removeIf(facility -> facility.getId().equals(id));
    }

    public Optional<Facility> updateFacility(Long id, Facility updatedFacility) {
        Optional<Facility> existingFacility = findById(id);
        existingFacility.ifPresent(facility -> {
            facility.setName(updatedFacility.getName());
            facility.setExpense(updatedFacility.getExpense());
        });
        return existingFacility;
    }
}
