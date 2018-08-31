package com.giannopoulos.spring5.rest.template.api.v1.mapper;

import com.giannopoulos.spring5.rest.template.domain.Recipe;
import com.giannopoulos.spring5.rest.template.model.RecipeDTO;
import org.mapstruct.Mapper;

@Mapper
public interface RecipeMapper {

    //RecipeMapper INSTANCE = Mappers.getMapper(RecipeMapper.class);

    RecipeDTO recipeToRecipeDTO(Recipe recipe);

    Recipe recipeDTOToRecipe(RecipeDTO recipeDTO);
}
