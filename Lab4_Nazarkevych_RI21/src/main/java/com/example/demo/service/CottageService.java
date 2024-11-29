package com.example.demo.service;

import com.example.demo.dto.CottageDTO;
import com.example.demo.entity.Cottage;
import com.example.demo.entity.Facility;
import com.example.demo.repository.CottageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CottageService {


    public List<CottageDTO> getAllCottages();

    public CottageDTO getCottageById(Long id);

    public CottageDTO createCottage(CottageDTO cottageDTO);

    public CottageDTO updateCottage(Long id, CottageDTO cottageDTO);

    public boolean deleteCottage(Long id);

    List<Facility> getAllFacilitiesForCottage(Long cottageId);
}
