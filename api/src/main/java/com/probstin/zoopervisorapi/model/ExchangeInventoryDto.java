package com.probstin.zoopervisorapi.model;

import java.util.List;

public class ExchangeInventoryDto {
    
    private List<ExchangeAnimal> animals;

    public ExchangeInventoryDto() {
    }

    public ExchangeInventoryDto(List<ExchangeAnimal> data) {
        this.animals = data;
    }

    public List<ExchangeAnimal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<ExchangeAnimal> data) {
        this.animals = data;
    }
    
}
