package com.probstin.zoopervisorapi.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AnimalExchangeInventoryDto {
    @JsonProperty("animals")
    private List<AnimalExchangeAnimal> data;

    public AnimalExchangeInventoryDto() {
    }

    public AnimalExchangeInventoryDto(List<AnimalExchangeAnimal> data) {
        this.data = data;
    }

    public List<AnimalExchangeAnimal> getData() {
        return data;
    }

    public void setData(List<AnimalExchangeAnimal> data) {
        this.data = data;
    }
}
