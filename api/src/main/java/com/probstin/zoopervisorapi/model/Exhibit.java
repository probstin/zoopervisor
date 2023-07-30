package com.probstin.zoopervisorapi.model;

import java.util.List;

public class Exhibit {
    private String uuid;
    private String name;
    private List<ExchangeAnimal> animals;

    public Exhibit(String uuid, String name, List<ExchangeAnimal> animals) {
        this.uuid = uuid;
        this.name = name;
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

    public List<ExchangeAnimal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<ExchangeAnimal> animals) {
        this.animals = animals;
    }

}
