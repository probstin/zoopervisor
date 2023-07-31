package com.probstin.zoopervisorapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.probstin.zoopervisorapi.exception.ApiRequestException;
import com.probstin.zoopervisorapi.http.catalog.CatalogClient;

@Service
public class CatalogService {

    Logger logger = LoggerFactory.getLogger(ExhibitService.class);

    private final CatalogClient catalogClient;

    @Autowired
    public CatalogService(CatalogClient catalogClient) {
        this.catalogClient = catalogClient;
    }

    public List<Object> getAnimalCatalog(String name, int limit) {
        List<Object> catalog;

        try {
            catalog = this.catalogClient
                    .getAnimalCatalog(name)
                    .stream()
                    .limit(limit)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new ApiRequestException("An error occurred while requesting animals from the catalog.");

        }

        return catalog;
    }

}
