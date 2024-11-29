package com.example.demo.controller;

import com.example.demo.dto.CottageDTO;
import com.example.demo.entity.Facility;
import com.example.demo.service.CottageService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cottages")
@AllArgsConstructor
public class CottageController {

    private final CottageService cottageService;

    @GetMapping
    public List<CottageDTO> getAllCottages() {
        return cottageService.getAllCottages();
    }

    @GetMapping("/{id}")
    public CottageDTO getCottageById(@PathVariable Long id) {
        return cottageService.getCottageById(id);
    }

    @PostMapping
    public CottageDTO createCottage(@Valid @RequestBody CottageDTO cottageDTO) {
        return cottageService.createCottage(cottageDTO);
    }

    @PutMapping("/{id}")
    public CottageDTO updateCottage(@PathVariable Long id,@RequestBody CottageDTO cottageDTO) {
        return cottageService.updateCottage(id, cottageDTO);
    }

    @DeleteMapping("/{id}")
    public boolean deleteCottage(@PathVariable Long id) {
        return cottageService.deleteCottage(id);
    }
    @GetMapping("/facilities/{cottageId}")
    public List<Facility> getAllFacilitiesForCottage(@PathVariable Long cottageId) {
        return cottageService.getAllFacilitiesForCottage(cottageId);
    }
}
