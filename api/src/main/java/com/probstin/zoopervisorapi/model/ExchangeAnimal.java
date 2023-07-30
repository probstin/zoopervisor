package com.probstin.zoopervisorapi.model;

public class ExchangeAnimal {
    
    private String species;
    private Integer spaces;

    public ExchangeAnimal() {
    }

    public ExchangeAnimal(String species, Integer spaces) {
        this.species = species.toUpperCase();
        this.spaces = spaces;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species.toUpperCase();
    }

    public Integer getSpaces() {
        return spaces;
    }

    public void setSpaces(Integer spaces) {
        this.spaces = spaces;
    }

}
