package com.probstin.zoopervisorapi.http.exchange;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import feign.RequestInterceptor;

public class ExchangeClientConfig {

    @Value("${exchange.client.apiKey}")
    private String apiKey;

    @Bean
    public RequestInterceptor exchangeRequestInterceptor() {
        return requestTemplate -> requestTemplate.header("X-Api-Key", this.apiKey);
    }

}
