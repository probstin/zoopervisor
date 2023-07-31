package com.probstin.zoopervisorapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.probstin.zoopervisorapi.exception.ApiRequestException;
import com.probstin.zoopervisorapi.model.ExchangeAnimal;
import com.probstin.zoopervisorapi.model.Exhibit;

@Service
public class ExhibitService {

    Logger logger = LoggerFactory.getLogger(ExhibitService.class);

    private final ExchangeService exchangeService;

    @Autowired
    public ExhibitService(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    public List<Exhibit> getExhibits() {
        List<Exhibit> exhibits = new ArrayList<>();
        AtomicInteger exhibitIndex = new AtomicInteger(1);
        Map<String, List<ExchangeAnimal>> animalsGroupedBySpecies;

        try {
            animalsGroupedBySpecies = this.exchangeService.getAnimalsGroupedBySpecies();
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new ApiRequestException("An error occurred while requesting animals from the exchange.");
        }

        animalsGroupedBySpecies
                .forEach((species, animalsBySpecies) -> {
                    int spacesUsed = 0;
                    List<ExchangeAnimal> currentExhibitAnimals = new ArrayList<>();

                    for (ExchangeAnimal animal : animalsBySpecies) {
                        if (spacesUsed + animal.getSpaces() > 20) {
                            exhibits.add(
                                    new Exhibit(
                                            UUID.randomUUID().toString(),
                                            animal.getSpecies().toUpperCase() + " EXHIBIT "
                                                    + exhibitIndex.getAndIncrement(),
                                            spacesUsed,
                                            new ArrayList<>(currentExhibitAnimals)));
                            currentExhibitAnimals.clear();
                            spacesUsed = 0;
                        }

                        currentExhibitAnimals.add(animal);
                        spacesUsed += animal.getSpaces();
                    }

                    if (!currentExhibitAnimals.isEmpty()) {
                        exhibits.add(
                                new Exhibit(
                                        UUID.randomUUID().toString(),
                                        species.toUpperCase() + " EXHIBIT " + exhibitIndex.getAndIncrement(),
                                        spacesUsed,
                                        currentExhibitAnimals));
                    }
                });

        return exhibits;

    }

}
