package com.probstin.zoopervisorapi.model;

import java.util.List;

public class Exhibit {
    private String uuid;
    private String name;
    private Integer spacesUsed;
    private List<ExchangeAnimal> animals;

    public Exhibit(String uuid, String name, Integer spacesUsed, List<ExchangeAnimal> animals) {
        this.uuid = uuid;
        this.name = name;
        this.spacesUsed = spacesUsed;
        this.animals = animals;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSpacesUsed() {
        return spacesUsed;
    }

    public void setSpacesUsed(Integer spacesUsed) {
        this.spacesUsed = spacesUsed;
    }

    public List<ExchangeAnimal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<ExchangeAnimal> animals) {
        this.animals = animals;
    }

}
