package miri.recipe.app.converters;

import miri.recipe.app.commands.NotesCommand;
import miri.recipe.app.domain.Notes;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;


@Component
public class NotesToNotesCommand  implements Converter<Notes,NotesCommand> {

    @Nullable
    @Override
    public NotesCommand convert(Notes notes) {
        return null;
    }

}
