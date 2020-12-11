package miri.recipe.app.services;


import lombok.extern.slf4j.Slf4j;
import miri.recipe.app.commands.IngredientCommand;
import miri.recipe.app.converters.IngredientToIngredientCommand;
import miri.recipe.app.domain.Recipe;
import miri.recipe.app.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final RecipeRepository recipeRepository;

    public IngredientServiceImpl(IngredientToIngredientCommand ingredientToIngredientCommand, RecipeRepository recipeRepository) {
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public IngredientCommand findbyRecipeIAndIngredientId(Long recipeId, Long ingredientId) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);

        if(!recipeOptional.isPresent()){
            log.error("Recipe id not found iD:"+ recipeId);
        }

        Recipe recipe =  recipeOptional.get();

        Optional<IngredientCommand> ingredientCommandOptional = recipe.getIngredients().stream()
                .filter(ingredient -> ingredient.getId().equals(ingredientId))
                .map(ingredient -> ingredientToIngredientCommand.convert(ingredient)).findFirst();

        if(!ingredientCommandOptional.isPresent()){
            log.error("ingredient not found "+ ingredientId);
        }
        return ingredientCommandOptional.get();
    }
}
