package miri.recipe.app.converters;

import miri.recipe.app.commands.RecipesCommand;
import miri.recipe.app.domain.Recipe;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;


@Component
public class RecipeToRecipeCommand implements Converter<Recipe, RecipesCommand> {

    @Nullable
    @Override
    public RecipesCommand convert(Recipe recipe) {
        return null;
    }
}
