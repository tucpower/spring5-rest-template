package com.giannopoulos.spring5.rest.template.api.v1.mapper;

import com.giannopoulos.spring5.rest.template.api.v1.model.RecipeDTO;
import com.giannopoulos.spring5.rest.template.domain.Recipe;
import org.mapstruct.Mapper;

@Mapper
public interface RecipeMapper {

    //RecipeMapper INSTANCE = Mappers.getMapper(RecipeMapper.class);

    RecipeDTO recipeToRecipeDTO(Recipe recipe);

    Recipe recipeDTOToRecipe(RecipeDTO recipeDTO);
}
