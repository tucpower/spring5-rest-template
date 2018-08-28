package com.giannopoulos.spring5.rest.template.repositories;

import com.giannopoulos.spring5.rest.template.domain.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
