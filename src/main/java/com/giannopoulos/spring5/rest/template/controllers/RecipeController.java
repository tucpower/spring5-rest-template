package com.giannopoulos.spring5.rest.template.controllers;

import com.giannopoulos.spring5.rest.template.api.v1.model.RecipeDTO;
import com.giannopoulos.spring5.rest.template.api.v1.model.RecipeListDTO;
import com.giannopoulos.spring5.rest.template.services.ApiService;
import com.giannopoulos.spring5.rest.template.services.RecipeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Api(description = "This is my Recipe Controller")
@RestController
@RequestMapping(RecipeController.BASE_URL)
public class RecipeController {

    public static final String BASE_URL = "/api/v1/recipes";

    private final RecipeService recipeService;
    private final ApiService apiService;

    public RecipeController(RecipeService recipeService, ApiService apiService) {
        this.recipeService = recipeService;
        this.apiService = apiService;
    }

    @ApiOperation(value = "This will get a list of recipes.", notes = "There are some notes about the API.")
    @GetMapping
    public RecipeListDTO getAllRecipies() {
        return new RecipeListDTO(recipeService.findAllRecipes());
    }

    @GetMapping("/{id}")
    public RecipeDTO getRecipeById(@PathVariable Long id) {
        return recipeService.findRecipeById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RecipeDTO saveRecipe(@RequestBody RecipeDTO recipeDTO) {
        return recipeService.saveRecipe(recipeDTO);
    }

    @PutMapping("/{id}")
    public RecipeDTO updateRecipe(@PathVariable Long id, @RequestBody RecipeDTO recipeDTO) {
        return recipeService.updateRecipe(id, recipeDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable Long id) {
        recipeService.deleteRecipeById(id);
    }

    @GetMapping("/test")
    public void testController() {

        apiService.testRestTemplate();
    }
}
