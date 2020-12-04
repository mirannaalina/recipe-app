package miri.recipe.app.commands;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import miri.recipe.app.domain.Category;
import miri.recipe.app.domain.Difficulty;
import miri.recipe.app.domain.Ingredient;
import miri.recipe.app.domain.Notes;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class RecipesCommand {

    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;
    private Set<IngredientCommand> ingredients = new HashSet<>();
    private Difficulty difficulty;
    private NotesCommand notes;
    private Set<CategoryCommand> categories = new HashSet<>();
}
