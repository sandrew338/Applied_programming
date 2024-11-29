package com.example.demo.service.impl;

import com.example.demo.dto.CottageDTO;
import com.example.demo.entity.Cottage;
import com.example.demo.entity.Facility;
import com.example.demo.entity.Hotel;
import com.example.demo.repository.CottageRepository;
import com.example.demo.repository.FacilityRepository;
import com.example.demo.service.CottageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class CottageServiceImpl implements CottageService {

    private final CottageRepository cottageRepository;
    private final FacilityRepository facilityRepository;


    @Override
    public List<CottageDTO> getAllCottages() {
        return cottageRepository.findAll().stream()
                .map(cottage -> new CottageDTO(
                        cottage.getId(),
                        cottage.getCategory(),
                        cottage.getBasePrice(),
                        cottage.getMaxGuests(),
                        cottage.getFacilities().stream()
                                .map(Facility::getId)
                                .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }

    @Override
    public CottageDTO getCottageById(Long id) {
        Cottage cottage = cottageRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cottage not found with ID: " + id));
        return new CottageDTO(
                cottage.getId(),
                cottage.getCategory(),
                cottage.getBasePrice(),
                cottage.getMaxGuests(),
                cottage.getFacilities().stream()
                        .map(Facility::getId)
                        .collect(Collectors.toList())
        );
    }

    @Override
    public CottageDTO createCottage(CottageDTO cottageDTO) {
        if (cottageDTO.getFacilityIds() == null || cottageDTO.getFacilityIds().isEmpty()) {
            throw new EntityNotFoundException("Cottage must have at least one facility.");
        }

        List<Facility> facilities = cottageDTO.getFacilityIds().stream()
                .map(facilityId -> facilityRepository.findById(facilityId)
                        .orElseThrow(() -> new EntityNotFoundException("Facility not found with ID: " + facilityId)))
                .collect(Collectors.toList());

        Cottage cottage = Cottage.builder()
                .id(cottageDTO.getId())
                .category(cottageDTO.getCategory())
                .basePrice(cottageDTO.getBasePrice())
                .maxGuests(cottageDTO.getMaxGuests())
                .facilities(facilities)
                .build();

        cottageRepository.save(cottage);
        return cottageDTO;
    }

    @Override
    public CottageDTO updateCottage(Long id, CottageDTO cottageDTO) {
        if (cottageDTO.getFacilityIds() == null || cottageDTO.getFacilityIds().isEmpty()) {
            throw new EntityNotFoundException("Cottage must have at least one facility.");
        }

        Cottage existingCottage = cottageRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cottage not found with ID: " + id));

        List<Facility> facilities = cottageDTO.getFacilityIds().stream()
                .map(facilityId -> facilityRepository.findById(facilityId)
                        .orElseThrow(() -> new EntityNotFoundException("Facility not found with ID: " + facilityId)))
                .collect(Collectors.toList());

        existingCottage.setCategory(cottageDTO.getCategory());
        existingCottage.setBasePrice(cottageDTO.getBasePrice());
        existingCottage.setMaxGuests(cottageDTO.getMaxGuests());
        existingCottage.setFacilities(facilities);

        cottageRepository.save(existingCottage);
        return cottageDTO;

    }

    @Override
    public boolean deleteCottage(Long id) {
        return cottageRepository.delete(id);
    }



    @Override
    public List<Facility> getAllFacilitiesForCottage(Long cottageId) {
        Cottage cottage = cottageRepository.findById(cottageId)
                .orElseThrow(() -> new EntityNotFoundException("Cottage not found with ID: " + cottageId));

        List<Facility> combinedFacilities = new ArrayList<>();
        combinedFacilities.addAll(cottage.getFacilities());


        //todo
        Hotel hotel = cottage.getHotel();
        if (hotel != null) {
            combinedFacilities.addAll(hotel.getFacilities());
        }

        return combinedFacilities;
    }
}

