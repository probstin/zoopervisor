package com.probstin.zoopervisorapi.http.exchange;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import com.probstin.zoopervisorapi.model.ExchangeInventoryDto;

@Component
@FeignClient(
    name = "${exchange.client.name}", 
    url = "${exchange.client.apiUrl}",
    contextId = "${exchange.client.name}",
    configuration = ExchangeClientConfig.class
)
public interface ExchangeClient {

    @GetMapping("/animals")
    public ExchangeInventoryDto getAnimalInventory();

}
