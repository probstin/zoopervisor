package com.probstin.zoopervisorapi.http.catalog;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "${catalog.client.name}", url = "${catalog.client.apiUrl}", configuration = CatalogClientConfig.class)
public interface CatalogClient {

    @GetMapping("/animals")
    public List<Object> getAnimalCatalog(@RequestParam() String name);

}
