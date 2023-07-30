package com.probstin.zoopervisorapi.http;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.RequestInterceptor;

@Configuration
public class ExchangeClientConfig {

    @Value("${exchange.client.apiKey}")
    String apiKey;

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> requestTemplate.header("X-Api-Key", this.apiKey);
    }

}
