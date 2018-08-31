package com.giannopoulos.spring5.rest.template.bootstrap;

import com.giannopoulos.spring5.rest.template.domain.*;
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

        if(recipeRepository.count() == 0L) {
            loadData();
        }
    }

    private void loadData() {
        System.out.println("Loading Categories...");

        Category c0 = new Category();
        c0.setDescription("Common");
        categoryRepository.save(c0);

        Category c1 = new Category();
        c1.setDescription("Greek");
        categoryRepository.save(c1);

        Category c2 = new Category();
        c2.setDescription("Italian");
        categoryRepository.save(c2);

        System.out.println("Loading Recipes...");

        Recipe r1 = new Recipe();
        r1.setDescription("Mousakas");
        r1.setServings(10);
        r1.setDifficulty(Difficulty.HARD);
        //r1.setImage();

        Notes n1= new Notes();
        n1.setRecipeNotes("This is a hard recipe.");

        r1.setNotes(n1);

        Ingredient i1 = new Ingredient();
        i1.setDescription("Salt");
        i1.setAmount(new BigDecimal(2));

        r1.addIngredient(i1);

        Ingredient i2 = new Ingredient();
        i2.setDescription("Pepper");
        i2.setAmount(new BigDecimal(1));

        r1.addIngredient(i2);

        List<Category> categoryList1 = new ArrayList<>();
        categoryList1.add(c0);
        categoryList1.add(c1);
        r1.setCategories(categoryList1);

        recipeRepository.save(r1);

        Recipe r2 = new Recipe();
        r2.setDescription("Pasta");
        r2.setServings(2);
        r2.setDifficulty(Difficulty.EASY);
        //r2.setImage();

        Notes n2= new Notes();
        n2.setRecipeNotes("Special local recipe.");

        r2.setNotes(n2);

        Ingredient i3 = new Ingredient();
        i3.setDescription("Sauce");
        i3.setAmount(new BigDecimal(3));

        r2.addIngredient(i3);

        Ingredient i4 = new Ingredient();
        i4.setDescription("Sugar");
        i4.setAmount(new BigDecimal(4));

        r2.addIngredient(i4);

        List<Category> categoryList2 = new ArrayList<>();
        categoryList2.add(c0);
        categoryList2.add(c2);
        r2.setCategories(categoryList2);

        recipeRepository.save(r2);

        System.out.println("Recipes saved: " + recipeRepository.count());
    }
}
