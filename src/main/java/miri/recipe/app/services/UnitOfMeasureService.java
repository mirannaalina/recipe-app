package miri.recipe.app.services;

import miri.recipe.app.commands.UnitOfMeasureCommand;
import miri.recipe.app.domain.UnitOfMeasure;

import java.util.Set;

public interface UnitOfMeasureService {

    Set<UnitOfMeasureCommand> ListAllUoms();
}
