package miri.recipe.app.bootstrap;

import lombok.extern.slf4j.Slf4j;
import miri.recipe.app.domain.*;
import miri.recipe.app.repositories.CategoryRepository;
import miri.recipe.app.repositories.RecipeRepository;
import miri.recipe.app.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent>{

    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        recipeRepository.saveAll(getRecipes());
        log.debug("Loading Bootstrap data");
    }

    private List<Recipe> getRecipes() {


        List<Recipe> recipes = new ArrayList<>(2);

        //get unit of measure

        Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByDescription("Each");

        if (!eachUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found");
        }

        Optional<UnitOfMeasure> tableSpoonUomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");

        if (!eachUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found");
        }
        Optional<UnitOfMeasure> teaspoonUomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        if (!eachUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found");
        }

        Optional<UnitOfMeasure> dashUomOptional = unitOfMeasureRepository.findByDescription("Dash");

        if (!eachUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found");
        }

        Optional<UnitOfMeasure> pintUomOptional = unitOfMeasureRepository.findByDescription("Pint");

        if (!eachUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found");
        }

        Optional<UnitOfMeasure> cupsUomOptional = unitOfMeasureRepository.findByDescription("Cup");

        if (!eachUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found");
        }

        //get optionals for unit of measure

        UnitOfMeasure eachUom =eachUomOptional.get();
        UnitOfMeasure tableSpoonUom = tableSpoonUomOptional.get();
        UnitOfMeasure teaspoonUom = teaspoonUomOptional.get();
        UnitOfMeasure dashUom =dashUomOptional.get();
        UnitOfMeasure pintUom =pintUomOptional.get();
        UnitOfMeasure cupsUom =cupsUomOptional.get();


        //get categories

        Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("American");

        if(!americanCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category not found");
        }

        Optional<Category> mexicanCategoryOptional = categoryRepository.findByDescription("Mexican");

        if(!mexicanCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category not found");
        }

        //get optionals for categories

        Category americanCategory = americanCategoryOptional.get();
        Category mexicanCategory = mexicanCategoryOptional.get();


        //------------------------------------
        //FIRST RECIPE
        Recipe guacRecipe =new Recipe();
        guacRecipe.setDescription("Perfect guacamole");
        guacRecipe.setPrepTime(10);
        guacRecipe.setCookTime(0);
        guacRecipe.setDirections("1 Cut the avocado, remove flesh: Cut the avocados in half. Remove the pit. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n" +
                "\n3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.");


        Notes guacNotes =new Notes();
        guacNotes.setRecipeNotes(" For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.");

        guacRecipe.setNotes(guacNotes);



        guacRecipe.addIngredient(new Ingredient("ripe avocados",new BigDecimal(2),eachUom));
        guacRecipe.addIngredient(new Ingredient("salt",new BigDecimal(1),tableSpoonUom));
        guacRecipe.addIngredient(new Ingredient("minced red onion",new BigDecimal(2),dashUom));
        guacRecipe.addIngredient(new Ingredient("ripe tomatos",new BigDecimal(".5"),eachUom));


        guacRecipe.getCategories().add(americanCategory);
        guacRecipe.getCategories().add(mexicanCategory);

        //add to return list
        recipes.add(guacRecipe);



        //---------------------------------------------------------
        //SECOND RECIPE
        Recipe tacosRecipe = new Recipe();
        tacosRecipe.setDescription("Spicy Griller Chicken Taco");
        tacosRecipe.setCookTime(9);
        tacosRecipe.setPrepTime(20);
        tacosRecipe.setDifficulty(Difficulty.MODERATE);

        tacosRecipe.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.");

        Notes tacoNotes = new Notes();
        tacoNotes.setRecipeNotes("notes taco");
        tacosRecipe.setNotes(tacoNotes);

        tacosRecipe.getIngredients().add(new Ingredient("Chili",new BigDecimal(2),tableSpoonUom));
        tacosRecipe.getIngredients().add(new Ingredient("sugar",new BigDecimal(1),eachUom));
        tacosRecipe.getIngredients().add(new Ingredient("sour cream",new BigDecimal(1),cupsUom));

        tacosRecipe.getCategories().add(americanCategory);
        tacosRecipe.getCategories().add(mexicanCategory);

        //add to return list
        recipes.add(tacosRecipe);

        return recipes;

    }

}
