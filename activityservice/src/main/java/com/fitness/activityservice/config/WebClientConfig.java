package com.fitness.activityservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
@Configuration
public class WebClientConfig {
    @Bean
    @LoadBalanced // want to get service by service-name, in place of complete url
    public WebClient.Builder webClient() {
        return WebClient.builder();
    }

    @Bean
    public  WebClient userServiceWebClient(WebClient.Builder builder) {
        return builder.baseUrl("http://USERSERVICE").build();
    }
}
