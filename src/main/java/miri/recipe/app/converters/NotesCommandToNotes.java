package miri.recipe.app.converters;

import miri.recipe.app.commands.NotesCommand;
import miri.recipe.app.domain.Notes;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;


@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {


    @Nullable
    @Override
    public Notes convert(NotesCommand source) {

        final Notes notes = new Notes();
        notes.setId(source.getId());
        notes.setRecipeNotes(source.getRecipeNotes());
        return notes;
    }
}
