package com.probstin.zoopervisorapi.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import com.probstin.zoopervisorapi.model.AnimalExchangeInventoryDto;

@Component
@FeignClient(name = "${animal.exchange.client.name}", url = "${animal.exchange.client.apiUrl}", configuration = AnimalExchangeClientConfig.class)
public interface AnimalExchangeClient {

    @GetMapping("/animals")
    public AnimalExchangeInventoryDto getInventory();

}
