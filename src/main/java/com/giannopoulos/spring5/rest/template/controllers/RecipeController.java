package com.giannopoulos.spring5.rest.template.controllers;

import com.giannopoulos.spring5.rest.template.domain.Recipe;
import com.giannopoulos.spring5.rest.template.services.ApiService;
import com.giannopoulos.spring5.rest.template.services.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(RecipeController.BASE_URL)
public class RecipeController {

    public static final String BASE_URL = "/api/v1/recipies";

    private final RecipeService recipeService;
    private final ApiService apiService;

    public RecipeController(RecipeService recipeService, ApiService apiService) {
        this.recipeService = recipeService;
        this.apiService = apiService;
    }

    @GetMapping
    public List<Recipe> getAllRecipies() {
        return recipeService.findAllRecipes();
    }

    @GetMapping("/{id}")
    public Recipe getRecipeById(@PathVariable Long id) {
        return recipeService.findRecipeById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Recipe saveRecipe(@RequestBody Recipe recipe) {
        return recipeService.saveRecipe(recipe);
    }

    @GetMapping("/test")
    public void testController() {

        apiService.testRestTemplate();
    }
}
