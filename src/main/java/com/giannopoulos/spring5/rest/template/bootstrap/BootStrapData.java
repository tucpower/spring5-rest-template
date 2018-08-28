package com.giannopoulos.spring5.rest.template.bootstrap;

import com.giannopoulos.spring5.rest.template.domain.Difficulty;
import com.giannopoulos.spring5.rest.template.domain.Ingredient;
import com.giannopoulos.spring5.rest.template.domain.Notes;
import com.giannopoulos.spring5.rest.template.domain.Recipe;
import com.giannopoulos.spring5.rest.template.repositories.CategoryRepository;
import com.giannopoulos.spring5.rest.template.repositories.RecipeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class BootStrapData implements CommandLineRunner {

    private final RecipeRepository recipeRepository;
    private final CategoryRepository categoryRepository;

    public BootStrapData(RecipeRepository recipeRepository, CategoryRepository categoryRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Loading Recipes...");

        Recipe r1 = new Recipe();
        r1.setDescription("Mousakas");
        r1.setServings(10);
        r1.setDifficulty(Difficulty.HARD);
        //r1.setImage();

        Notes n1= new Notes();
        n1.setRecipeNotes("This is a hard recipe.");
        r1.setNotes(n1);

        List<Ingredient> ingredientList1 = new ArrayList<>();
        Ingredient i1 = new Ingredient();
        i1.setDescription("Salt");
        i1.setAmount(new BigDecimal(2));
        ingredientList1.add(i1);
        Ingredient i2 = new Ingredient();
        i2.setDescription("Pasta");
        i2.setAmount(new BigDecimal(1));
        ingredientList1.add(i2);
        r1.setIngredients(ingredientList1);

        //List<Category> categoryList1 = new ArrayList<>();
        //Category c1 = new Category();
        //c1.setDescription("Greek");
        //categoryRepository.save(c1);
        //categoryList1.add(c1);
        //r1.setCategories(categoryList1);

        recipeRepository.save(r1);

        Recipe c2 = new Recipe();
        c2.setDescription("Second description");
        c2.setServings(2);

        Notes n2= new Notes();
        n2.setRecipeNotes("Recipe Notes Two");

        c2.setNotes(n2);
        recipeRepository.save(c2);

        System.out.println("Recipes saved: " + recipeRepository.count());
    }
}
