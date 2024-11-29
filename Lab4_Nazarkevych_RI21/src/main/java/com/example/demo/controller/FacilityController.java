package com.example.demo.controller;

import com.example.demo.dto.FacilityDTO;
import com.example.demo.service.FacilityService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/facilities")
public class FacilityController {

    private final FacilityService facilityService;

    public FacilityController(FacilityService facilityService) {
        this.facilityService = facilityService;
    }

    @GetMapping
    public List<FacilityDTO> getAllFacilities() {
        return facilityService.getAllFacilities();
    }

    @GetMapping("/{id}")
    public Optional<FacilityDTO> getFacilityById(@PathVariable Long id) {
        return facilityService.getFacilityById(id);
    }

    @PostMapping
    public FacilityDTO createFacility(@Valid  @RequestBody FacilityDTO facilityDTO) {
        return facilityService.createFacility(facilityDTO);
    }

    @PutMapping("/{id}")
    public Optional<FacilityDTO> updateFacility(@PathVariable Long id, @RequestBody FacilityDTO facilityDTO) {
        return facilityService.updateFacility(id, facilityDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteFacility(@PathVariable Long id) {
        facilityService.deleteFacility(id);
    }
}
