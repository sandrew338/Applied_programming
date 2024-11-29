package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.Facility;
import com.example.demo.repository.FacilityRepository;
import com.example.demo.dto.FacilityDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public interface FacilityService {

    public List<FacilityDTO> getAllFacilities();

    public Optional<FacilityDTO> getFacilityById(Long id);

    public FacilityDTO createFacility(FacilityDTO facilityDTO);

    Optional<FacilityDTO> updateFacility(Long id, FacilityDTO facilityDTO);

    public void deleteFacility(Long id);
}
