package com.giannopoulos.spring5.rest.template.api.v1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.giannopoulos.spring5.rest.template.domain.Category;
import com.giannopoulos.spring5.rest.template.domain.Difficulty;
import com.giannopoulos.spring5.rest.template.domain.Ingredient;
import com.giannopoulos.spring5.rest.template.domain.Notes;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

public class RecipeDTO {

    private Long id;

    @ApiModelProperty(value = "This is the description", required = true)
    private String description;

    @ApiModelProperty(value = "These are the servings", required = true)
    private Integer servings;

    private Difficulty difficulty;

    @JsonIgnore
    private Byte[] image;

    private Notes notes;
    private List<Ingredient> ingredients = new ArrayList<>();
    private List<Category> categories = new ArrayList<>();

    @JsonProperty("recipe_url")
    private String recipeUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getServings() {
        return servings;
    }

    public void setServings(Integer servings) {
        this.servings = servings;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public Notes getNotes() {
        return notes;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getRecipeUrl() {
        return recipeUrl;
    }

    public void setRecipeUrl(String recipeUrl) {
        this.recipeUrl = recipeUrl;
    }
}
