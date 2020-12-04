package miri.recipe.app.commands;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import miri.recipe.app.domain.Recipe;

@Getter
@Setter
@NoArgsConstructor
public class NotesCommand {

    private Long id;
    private Recipe recipe;
    private String recipeNotes;
}

