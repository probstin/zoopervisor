package com.probstin.zoopervisorapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.probstin.zoopervisorapi.http.AnimalExchangeClient;
import com.probstin.zoopervisorapi.model.AnimalExchangeAnimal;

@RestController
@RequestMapping("v1/exchange")
public class AnimalExchangeController {

    private final AnimalExchangeClient animalExchangeClient;

    public AnimalExchangeController(AnimalExchangeClient animalExchangeClient) {
        this.animalExchangeClient = animalExchangeClient;
    }

    @GetMapping("/inventory")
    public List<AnimalExchangeAnimal> getExchangeInventory() {
        return this.animalExchangeClient
            .getInventory()
            .getData();
    }

}
