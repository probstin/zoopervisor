package com.probstin.zoopervisorapi.model;

public class AnimalExchangeAnimal {
    private String species;
    private Integer spaces;

    public AnimalExchangeAnimal() {
    }

    public AnimalExchangeAnimal(String species, Integer spaces) {
        this.species = species.toUpperCase();
        this.spaces = spaces;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public Integer getSpaces() {
        return spaces;
    }

    public void setSpaces(Integer spaces) {
        this.spaces = spaces;
    }
}
