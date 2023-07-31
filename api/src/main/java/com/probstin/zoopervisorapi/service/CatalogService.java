package com.probstin.zoopervisorapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.probstin.zoopervisorapi.http.catalog.CatalogClient;

@Service
public class CatalogService {

    private final CatalogClient catalogClient;

    @Autowired
    public CatalogService(CatalogClient catalogClient) {
        this.catalogClient = catalogClient;
    }

    public List<Object> getAnimalCatalog(String name, int limit) {
        return this.catalogClient
                .getAnimalCatalog(name)
                .stream()
                .limit(limit)
                .collect(Collectors.toList());
    }

}
