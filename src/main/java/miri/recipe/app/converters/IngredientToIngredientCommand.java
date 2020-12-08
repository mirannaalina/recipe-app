package miri.recipe.app.converters;

import miri.recipe.app.commands.IngredientCommand;
import miri.recipe.app.domain.Ingredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;


@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

    @Nullable
    @Override
    public IngredientCommand convert(Ingredient source) {
        final IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(source.getId());
        ingredientCommand.setAmount(source.getAmount());
        ingredientCommand.setDescription(source.getDescription());
        ingredientCommand.setRecipe(source.getRecipe());
        return ingredientCommand;
    }
}
