package com.giannopoulos.spring5.rest.template.services;

import com.giannopoulos.spring5.rest.template.api.v1.mapper.RecipeMapper;
import com.giannopoulos.spring5.rest.template.controllers.RecipeController;
import com.giannopoulos.spring5.rest.template.domain.Recipe;
import com.giannopoulos.spring5.rest.template.exceptions.NotFoundException;
import com.giannopoulos.spring5.rest.template.model.RecipeDTO;
import com.giannopoulos.spring5.rest.template.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeMapper recipeMapper;
    private final RecipeRepository recipeRepository;
    //private final CategoryRepository categoryRepository;
    //private final Ingredient

    public RecipeServiceImpl(RecipeMapper recipeMapper, RecipeRepository recipeRepository) {
        this.recipeMapper = recipeMapper;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<RecipeDTO> findAllRecipes() {

        return recipeRepository.findAll()
                .stream()
                .map(recipe -> {
                    RecipeDTO recipeDTO = recipeMapper.recipeToRecipeDTO(recipe);
                    recipeDTO.setRecipeUrl(getRecipeUrl(recipe.getId()));
                    return recipeDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public RecipeDTO findRecipeById(Long id) {

        return recipeRepository.findById(id)
                .map(recipe -> {
                    RecipeDTO recipeDTO = recipeMapper.recipeToRecipeDTO(recipe);
                    recipeDTO.setRecipeUrl(getRecipeUrl(id));
                    return recipeDTO;
                })
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public RecipeDTO saveRecipe(RecipeDTO recipeDTO) {

        return saveAndReturnDTO(recipeMapper.recipeDTOToRecipe(recipeDTO));
    }

    @Override
    public RecipeDTO updateRecipe(Long id, RecipeDTO recipeDTO) {
        Recipe recipe = recipeMapper.recipeDTOToRecipe(recipeDTO);
        recipe.setId(id);

        return saveAndReturnDTO(recipe);
    }

    @Override
    public void deleteRecipeById(Long id) {
        recipeRepository.deleteById(id);
    }

    // Helper Methods

    private String getRecipeUrl(Long id) {
        return RecipeController.BASE_URL + "/" + id;
    }

    private RecipeDTO saveAndReturnDTO(Recipe recipe) {

        Recipe savedRecipe = recipeRepository.save(recipe);

        RecipeDTO returnDTO = recipeMapper.recipeToRecipeDTO(savedRecipe);

        returnDTO.setRecipeUrl(getRecipeUrl(savedRecipe.getId()));

        return returnDTO;
    }
}
