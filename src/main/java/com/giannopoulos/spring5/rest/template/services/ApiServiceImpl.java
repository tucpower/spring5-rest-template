package com.giannopoulos.spring5.rest.template.services;

import com.giannopoulos.spring5.rest.template.domain.Recipe;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {

    private final RestTemplate restTemplate;

    public ApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Recipe> getAllRecipies() {

        return  restTemplate.getForObject("http://localhost:8090/api/v1/recipies", List.class);
    }
}
