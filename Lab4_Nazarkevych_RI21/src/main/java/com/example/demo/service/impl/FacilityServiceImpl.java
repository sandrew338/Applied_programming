package com.example.demo.service.impl;

import com.example.demo.entity.Facility;
import com.example.demo.repository.FacilityRepository;
import com.example.demo.dto.FacilityDTO;
import com.example.demo.service.FacilityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FacilityServiceImpl implements FacilityService {

    private final FacilityRepository facilityRepository;

    public List<FacilityDTO> getAllFacilities() {
        return facilityRepository.findAll().stream()
                .map(facility -> new FacilityDTO(facility.getId(), facility.getName(), facility.getExpense()))
                .collect(Collectors.toList());
    }

    public Optional<FacilityDTO> getFacilityById(Long id) {
        return facilityRepository.findById(id)
                .map(facility -> new FacilityDTO(facility.getId(), facility.getName(), facility.getExpense()));
    }

    public FacilityDTO createFacility(FacilityDTO facilityDTO) {
        Facility facility = new Facility(facilityDTO.getId(), facilityDTO.getName(), facilityDTO.getExpense());
        facilityRepository.save(facility);
        return facilityDTO;
    }

    @Override
    public Optional<FacilityDTO> updateFacility(Long id, FacilityDTO facilityDTO) {
        Facility updatedFacility = new Facility(facilityDTO.getId(), facilityDTO.getName(), facilityDTO.getExpense());
        Optional<Facility> facility = facilityRepository.updateFacility(id, updatedFacility);
        return facility.map(f -> new FacilityDTO(f.getId(), f.getName(), f.getExpense()));
    }

    // Видалити зручність за ID
    public void deleteFacility(Long id) {
        facilityRepository.deleteById(id);
    }
}
