package com.probstin.zoopervisorapi.http.catalog;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import feign.RequestInterceptor;

public class CatalogClientConfig {

    @Value("${catalog.client.apiKey}")
    private String apiKey;

    @Bean
    public RequestInterceptor catalogRequestInterceptor() {
        return requestTemplate -> requestTemplate.header("X-Api-Key", this.apiKey);
    }

}
