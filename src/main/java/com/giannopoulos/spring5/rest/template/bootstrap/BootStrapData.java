package com.giannopoulos.spring5.rest.template.bootstrap;

import com.giannopoulos.spring5.rest.template.domain.Notes;
import com.giannopoulos.spring5.rest.template.domain.Recipe;
import com.giannopoulos.spring5.rest.template.repositories.RecipeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final RecipeRepository recipeRepository;

    public BootStrapData(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Loading Recipe Data");

        Recipe c1 = new Recipe();
        c1.setDescription("First description");
        c1.setServings(1);

        Notes n1= new Notes();
        n1.setRecipeNotes("Recipe Notes One");

        c1.setNotes(n1);
        recipeRepository.save(c1);

        Recipe c2 = new Recipe();
        c2.setDescription("Second description");
        c2.setServings(2);

        Notes n2= new Notes();
        n2.setRecipeNotes("Recipe Notes Two");

        c2.setNotes(n2);
        recipeRepository.save(c2);

        Recipe c3 = new Recipe();
        c3.setDescription("Third description");
        c3.setServings(3);

        Notes n3= new Notes();
        n3.setRecipeNotes("Recipe Notes Three");

        c3.setNotes(n3);
        recipeRepository.save(c3);

        System.out.println("Recipe saved: " + recipeRepository.count());
    }
}
