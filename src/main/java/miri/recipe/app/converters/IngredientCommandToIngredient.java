package miri.recipe.app.converters;

import miri.recipe.app.commands.IngredientCommand;
import miri.recipe.app.domain.Ingredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;


@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {

    @Nullable
    @Override
    public Ingredient convert(IngredientCommand ingredientCommand) {
        return null;
    }
}