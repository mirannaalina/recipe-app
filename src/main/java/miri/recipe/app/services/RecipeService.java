package miri.recipe.app.services;

import com.sun.org.apache.regexp.internal.RE;
import miri.recipe.app.commands.RecipesCommand;
import miri.recipe.app.domain.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long l);

    RecipesCommand saveRecipeCommand(RecipesCommand command);


}
