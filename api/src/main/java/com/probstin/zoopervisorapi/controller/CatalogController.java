package com.probstin.zoopervisorapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.probstin.zoopervisorapi.service.CatalogService;

@RestController
@RequestMapping("v1/catalog")
public class CatalogController {

    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping
    public ResponseEntity<List<Object>> getAnimalCatalog(
            @RequestParam(defaultValue = "empty") String name,
            @RequestParam(defaultValue = "0") Integer limit) {
        List<Object> catalogResponse = new ArrayList<>();

        if (!name.equals("empty") && !limit.equals(0)) {
            catalogResponse = this.catalogService.getAnimalCatalog(name, limit);
        }

        return ResponseEntity.ok().body(catalogResponse);
    }

}
