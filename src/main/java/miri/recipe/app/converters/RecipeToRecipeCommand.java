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
    public RecipesCommand convert(Recipe source) {

        final RecipesCommand recipesCommand =  new RecipesCommand();
        recipesCommand.setId(source.getId());
        recipesCommand.setDescription(source.getDescription());
        recipesCommand.setPrepTime(source.getPrepTime());
        recipesCommand.setCookTime(source.getCookTime());
        recipesCommand.setServings(source.getServings());
        recipesCommand.setSource(source.getSource());
        recipesCommand.setUrl(source.getUrl());

        return recipesCommand;
    }
}
