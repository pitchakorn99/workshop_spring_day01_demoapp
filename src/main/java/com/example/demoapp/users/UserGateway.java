package com.example.demoapp.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class UserGateway {
    private final RestTemplate restTemplate;
    private String apiHost;

    @Autowired
    public UserGateway(RestTemplateBuilder builder, @Value("${external_api_url}") String apiHost) {
        this.restTemplate = builder.build();
        this.apiHost = apiHost;
    }

    public Optional<Users> getPostById(int id) {
        String url = String.format("%s/users/%d", apiHost, id);

        try {
            return Optional.ofNullable(restTemplate.getForObject(url, Users.class));
        } catch (RestClientException e) {
            return Optional.empty();
        }
    }
}
