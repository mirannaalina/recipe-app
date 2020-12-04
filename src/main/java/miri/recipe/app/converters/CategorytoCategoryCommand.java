package miri.recipe.app.converters;

import miri.recipe.app.commands.CategoryCommand;
import miri.recipe.app.domain.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;


@Component
public class CategorytoCategoryCommand implements Converter<Category, CategoryCommand> {

    @Nullable
    @Override
    public CategoryCommand convert(Category category) {
        return null;
    }
}
