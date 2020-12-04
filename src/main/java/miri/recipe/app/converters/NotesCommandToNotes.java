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
    public Notes convert(NotesCommand notesCommand) {
        return null;
    }
}
