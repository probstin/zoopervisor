package com.probstin.zoopervisorapi.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.probstin.zoopervisorapi.http.exchange.ExchangeClient;
import com.probstin.zoopervisorapi.model.ExchangeAnimal;

@Service
public class ExchangeService {

    private final ExchangeClient exchangeClient;

    @Autowired
    public ExchangeService(ExchangeClient animalExchangeClient) {
        this.exchangeClient = animalExchangeClient;
    }

    public Map<String, List<ExchangeAnimal>> getAnimalsGroupedBySpecies() {
        return this.exchangeClient
                .getAnimalInventory()
                .getAnimals()
                .stream()
                .collect(Collectors.groupingBy(ExchangeAnimal::getSpecies));
    }

}
