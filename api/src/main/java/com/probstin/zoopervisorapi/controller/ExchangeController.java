package com.probstin.zoopervisorapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.probstin.zoopervisorapi.http.ExchangeClient;
import com.probstin.zoopervisorapi.model.ExchangeAnimal;

@RestController
@RequestMapping("v1/exchange")
public class ExchangeController {

    private final ExchangeClient exchangeClient;

    public ExchangeController(ExchangeClient exchangeClient) {
        this.exchangeClient = exchangeClient;
    }

    @GetMapping("/inventory")
    public ResponseEntity<List<ExchangeAnimal>> getExchangeInventory() {
        List<ExchangeAnimal> exchangeInventory = this.exchangeClient
                .getAnimalInventory()
                .getAnimals();

        return ResponseEntity
                .ok()
                .body(exchangeInventory);
    }

}
