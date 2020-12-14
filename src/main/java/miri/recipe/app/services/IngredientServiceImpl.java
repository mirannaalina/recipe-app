package miri.recipe.app.services;


import lombok.extern.slf4j.Slf4j;
import miri.recipe.app.commands.IngredientCommand;
import miri.recipe.app.converters.IngredientCommandToIngredient;
import miri.recipe.app.converters.IngredientToIngredientCommand;
import miri.recipe.app.domain.Ingredient;
import miri.recipe.app.domain.Recipe;
import miri.recipe.app.repositories.RecipeRepository;
import miri.recipe.app.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final IngredientCommandToIngredient ingredientCommandToIngredient;

    public IngredientServiceImpl(IngredientToIngredientCommand ingredientToIngredientCommand, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository, IngredientCommandToIngredient ingredientCommandToIngredient) {
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository=unitOfMeasureRepository;
        this.ingredientCommandToIngredient= ingredientCommandToIngredient;
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

    @Override
    public IngredientCommand saveIngredientCommand(IngredientCommand command) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(command.getRecipeId());

        if(!recipeOptional.isPresent()){
            log.error("Recipe not found for: "+command.getRecipeId());
            return new IngredientCommand();
        }else{
            Recipe recipe = recipeOptional.get();

            Optional<Ingredient> ingredientOptional  = recipe.getIngredients()
                    .stream().filter(ingredient -> ingredient.getId().equals(command.getId())).findFirst();

            if(ingredientOptional.isPresent()){
                Ingredient ingredientFound = ingredientOptional.get();
                ingredientFound.setDescription(command.getDescription());
                ingredientFound.setAmount(command.getAmount());
                ingredientFound.setUom(unitOfMeasureRepository.findById(command.getUom().getId()).orElseThrow(()->new RuntimeException("UOM NOT Found")));
            }else{
                recipe.addIngredient(ingredientCommandToIngredient.convert(command));
            }

            Recipe savedRecipe = recipeRepository.save(recipe);

            return ingredientToIngredientCommand.convert(savedRecipe.getIngredients().stream()
            .filter(recipeIngredients -> recipeIngredients.getId().equals(command.getId())).findFirst().get());
        }

    }
}
