package com.probstin.zoopervisorapi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.probstin.zoopervisorapi.model.ExchangeAnimal;
import com.probstin.zoopervisorapi.service.ExhibitService;

@RestController
@RequestMapping("v1/exhibits")
public class ExhibitController {

    private final ExhibitService exhibitService;

    @Autowired
    public ExhibitController(ExhibitService exhibitService) {
        this.exhibitService = exhibitService;
    }

    @GetMapping
    public ResponseEntity<Map<String, List<ExchangeAnimal>>> getExhibits() {
        Map<String, List<ExchangeAnimal>> exhibits = this.exhibitService
            .getAnimalsGroupedBySpecies();
            
        return ResponseEntity.ok().body(exhibits);
    }

}
