package com.giannopoulos.spring5.rest.template.api.v1.model;

import java.util.List;

public class RecipeListDTOo {

    private List<RecipeDTOo> recipies;

    public RecipeListDTOo(List<RecipeDTOo> recipies) {
        this.recipies = recipies;
    }

    public List<RecipeDTOo> getRecipies() {
        return recipies;
    }

    public void setRecipies(List<RecipeDTOo> recipies) {
        this.recipies = recipies;
    }
}
