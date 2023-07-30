package com.probstin.zoopervisorapi.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.probstin.zoopervisorapi.http.ExchangeClient;
import com.probstin.zoopervisorapi.model.ExchangeAnimal;

@Service
public class ExhibitService {

    private ExchangeClient animalExchangeClient;

    @Autowired
    public ExhibitService(ExchangeClient animalExchangeClient) {
        this.animalExchangeClient = animalExchangeClient;
    }

    public Map<String, List<ExchangeAnimal>> getAnimalsGroupedBySpecies() {
        return this.animalExchangeClient
                .getAnimalInventory()
                .getAnimals()
                .stream()
                .collect(Collectors.groupingBy(ExchangeAnimal::getSpecies));
    }

}
