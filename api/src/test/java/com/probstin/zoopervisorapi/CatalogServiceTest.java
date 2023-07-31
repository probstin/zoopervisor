package com.probstin.zoopervisorapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.probstin.zoopervisorapi.exception.ApiRequestException;
import com.probstin.zoopervisorapi.http.catalog.CatalogClient;
import com.probstin.zoopervisorapi.service.CatalogService;

@ExtendWith(MockitoExtension.class)
public class CatalogServiceTest {

    @Mock
    private CatalogClient catalogClient;

    @InjectMocks
    private CatalogService catalogService;

    @Test
    void shouldLimitTheList() {
        // Arrange
        List<Object> animalsInCatalog = new ArrayList<>();

        animalsInCatalog.add("Lion");
        animalsInCatalog.add("Lion");
        animalsInCatalog.add("Lion");

        when(catalogService.getAnimalCatalog("Lion", 2)).thenReturn(animalsInCatalog);

        // Act
        List<Object> animals = catalogService.getAnimalCatalog("Lion", 2);

        // Assert
        assertEquals(2, animals.size());
    }

    @Test
    void shouldThrowACustomErrorWhenTheClientFails() {
        // Arrange
        when(catalogClient.getAnimalCatalog("Alligator")).thenThrow(RuntimeException.class);

        // Act
        assertThrows(ApiRequestException.class, () -> catalogService.getAnimalCatalog("Alligator", 5));
    }
    
}
