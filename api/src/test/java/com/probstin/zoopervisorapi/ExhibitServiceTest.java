package com.probstin.zoopervisorapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.probstin.zoopervisorapi.model.ExchangeAnimal;
import com.probstin.zoopervisorapi.model.Exhibit;
import com.probstin.zoopervisorapi.service.ExchangeService;
import com.probstin.zoopervisorapi.service.ExhibitService;

@ExtendWith(MockitoExtension.class)
public class ExhibitServiceTest {

    @Mock
    private ExchangeService exchangeService;

    @InjectMocks
    private ExhibitService exhibitService;

    @Test
    void shouldOrganizeExhibits() {
        // Arrange
        ExchangeAnimal lion = new ExchangeAnimal("lion", 5);
        ExchangeAnimal tiger = new ExchangeAnimal("tiger", 5);
        ExchangeAnimal bear = new ExchangeAnimal("bear", 5);
        Map<String, List<ExchangeAnimal>> groupedAnimals = new LinkedHashMap<>();
        List<ExchangeAnimal> lions = Arrays.asList(lion, lion, lion, lion);
        List<ExchangeAnimal> tigers = Arrays.asList(tiger, tiger);
        List<ExchangeAnimal> bears = Arrays.asList(bear, bear, bear);

        groupedAnimals.put("lion", lions);
        groupedAnimals.put("tiger", tigers);
        groupedAnimals.put("bear", bears);

        when(exchangeService.getAnimalsGroupedBySpecies()).thenReturn(groupedAnimals);

        // Act
        List<Exhibit> exhibits = exhibitService.getExhibits();

        // Assert
        assertEquals(lions, exhibits.get(0).getAnimals());
        assertEquals(tigers, exhibits.get(1).getAnimals());
        assertEquals(bears, exhibits.get(2).getAnimals());
    }

    @Test
    void shouldEnforceAnExhibitSpaceCap() {
        // Arrange
        ExchangeAnimal lion = new ExchangeAnimal("lion", 10);
        Map<String, List<ExchangeAnimal>> groupedAnimals = new LinkedHashMap<>();
        List<ExchangeAnimal> lions = Arrays.asList(lion, lion, lion, lion);

        groupedAnimals.put("lion", lions);

        when(exchangeService.getAnimalsGroupedBySpecies()).thenReturn(groupedAnimals);

        // Act
        List<Exhibit> exhibits = exhibitService.getExhibits();

        // Assert
        assertEquals(2, exhibits.size());
    }

}
