package miri.recipe.app.converters;

import miri.recipe.app.commands.CategoryCommand;
import miri.recipe.app.domain.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;


@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand,Category> {

    @Nullable
    @Override
    public Category convert(CategoryCommand source) {
        final Category category =  new Category();
        category.setId(source.getId());
        category.setDescription(source.getDescription());
        return category;
    }
}
