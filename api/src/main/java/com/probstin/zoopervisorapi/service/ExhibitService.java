package com.probstin.zoopervisorapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.probstin.zoopervisorapi.http.exchange.ExchangeClient;
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
                .forEach((species, animalsBySpecies) -> {
                    int spacesUsed = 0;
                    List<ExchangeAnimal> currentExhibitAnimals = new ArrayList<>();

                    for (ExchangeAnimal animal : animalsBySpecies) {
                        if (spacesUsed + animal.getSpaces() > 20) {
                            exhibits.add(
                                    new Exhibit(
                                            UUID.randomUUID().toString(),
                                            animal.getSpecies().toUpperCase() + " EXHIBIT",
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
                                        species.toUpperCase() + " EXHIBIT",
                                        spacesUsed,
                                        currentExhibitAnimals));
                    }
                });

        return exhibits;
    }

    // TODO
    // create an Exhibit model
    // transform: {"SPECIES": {"species": "", "spaces": n }, ... }
    // into:{ "exhibits": [ { "uuid": "", "name": "", "animals": [...] }, ... ] }

    // TODO
    // set a global exhibit list
    // for each species key & associated list
    // set a scoped space count
    // set a scoped exhibit list
    // loop through the associated list
    // check the spacesUsed + current animal spaces
    // if it's more than 20, add the entry to the exhibit list and reset scope state
    // if it's not add to the scoped exhibit list and increment the space count
}
