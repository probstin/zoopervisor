package com.probstin.zoopervisorapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.probstin.zoopervisorapi.http.ExchangeClient;
import com.probstin.zoopervisorapi.model.ExchangeAnimal;
import com.probstin.zoopervisorapi.model.Exhibit;

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

    public List<Exhibit> getExhibits() {
        List<Exhibit> exhibits = new ArrayList<>();

        this.getAnimalsGroupedBySpecies()
                .forEach((species, animalsInSpecies) -> {
                    Exhibit exhibit = new Exhibit(
                            UUID.randomUUID().toString(),
                            species + " EXHIBIT",
                            new ArrayList<>(animalsInSpecies));

                    exhibits.add(exhibit);
                });

        return exhibits;
    }

    // TODO
    // create an Exhibit model
    // transform: {"SPECIES": {"species": "", "spaces": n }, ... }
    // into: [ { "uuid": "", "name": "", "animals": [...] }, ... ]

}
