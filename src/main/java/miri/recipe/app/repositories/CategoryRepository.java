package miri.recipe.app.repositories;

import miri.recipe.app.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
