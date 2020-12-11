package miri.recipe.app.services;

import com.sun.org.apache.regexp.internal.RE;
import miri.recipe.app.commands.IngredientCommand;
import miri.recipe.app.controllers.IngredientController;
import miri.recipe.app.domain.Ingredient;
import miri.recipe.app.domain.Recipe;
import miri.recipe.app.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class IngredientServiceImplTest {


    private final RecipeRepository recipeRepository;
    private  final  IngredientService ingredientService;


    public IngredientServiceImplTest(RecipeRepository recipeRepository, IngredientService ingredientService) {
        this.recipeRepository = recipeRepository;
        this.ingredientService = ingredientService;
    }

    @BeforeEach
    void setUp() {
    }

    @Test
    void findbyRecipeIAndIngredientId() throws Exception{
        //given

        Recipe recipe = new Recipe();
        recipe.setId(1L);

        Ingredient ingredient1 = new Ingredient();
        ingredient1.setId(1L);

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setId(2L);

        Ingredient ingredient3 = new Ingredient();
        ingredient3.setId(3L);

        recipe.addIngredient(ingredient1);
        recipe.addIngredient(ingredient2);
        recipe.addIngredient(ingredient3);

        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        //then

        IngredientCommand ingredientCommand =ingredientService.findbyRecipeIAndIngredientId(1L,3L);

        //when

        assertEquals(Long.valueOf(3L),ingredientCommand.getId());
        assertEquals(Long.valueOf(1L),ingredientCommand.getRecipeId());
        verify(recipeRepository, times(1)).findById(anyLong());
    }

}