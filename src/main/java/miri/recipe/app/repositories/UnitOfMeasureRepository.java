package miri.recipe.app.repositories;

import miri.recipe.app.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure,Long>{


    Optional<UnitOfMeasure> findByDescription(String description);
}
