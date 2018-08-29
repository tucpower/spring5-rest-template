package com.giannopoulos.spring5.rest.template.services;

import com.giannopoulos.spring5.rest.template.domain.Recipe;

import java.util.List;

public interface ApiService {

    List<Recipe> getAllRecipies();
}
