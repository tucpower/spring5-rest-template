package com.giannopoulos.spring5.rest.template.services;

import com.giannopoulos.spring5.rest.template.api.v1.model.RecipeDTO;

import java.util.List;

public interface RecipeService {

    List<RecipeDTO> findAllRecipes();

    RecipeDTO findRecipeById(Long id);

    RecipeDTO saveRecipe(RecipeDTO recipeDTO);

    RecipeDTO updateRecipe(Long id, RecipeDTO recipeDTO);

    void deleteRecipeById(Long id);
}
