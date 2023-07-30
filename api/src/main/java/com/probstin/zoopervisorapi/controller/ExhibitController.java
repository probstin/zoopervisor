package com.probstin.zoopervisorapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.probstin.zoopervisorapi.model.Exhibit;
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
    public ResponseEntity<List<Exhibit>> getExhibits() {
        List<Exhibit> exhibits = this.exhibitService
                .getExhibits();

        return ResponseEntity
                .ok()
                .body(exhibits);
    }

}
