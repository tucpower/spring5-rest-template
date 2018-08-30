package com.giannopoulos.spring5.rest.template.api.v1.model;

import java.util.List;

public class RecipeListDTO {

    private List<RecipeDTO> recipies;

    public RecipeListDTO(List<RecipeDTO> recipies) {
        this.recipies = recipies;
    }

    public List<RecipeDTO> getRecipies() {
        return recipies;
    }

    public void setRecipies(List<RecipeDTO> recipies) {
        this.recipies = recipies;
    }
}
