package miri.recipe.app.services;

import miri.recipe.app.domain.Recipe;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface RecipeSevice {

    Set<Recipe> getRecipes();
}
