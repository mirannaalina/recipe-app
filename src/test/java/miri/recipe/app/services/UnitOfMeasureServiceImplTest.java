package miri.recipe.app.services;

import miri.recipe.app.commands.UnitOfMeasureCommand;
import miri.recipe.app.converters.UnitOfMeasureToUnitOfMeasureCommand;
import miri.recipe.app.domain.UnitOfMeasure;
import miri.recipe.app.repositories.UnitOfMeasureRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UnitOfMeasureServiceImplTest {

    UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand = new UnitOfMeasureToUnitOfMeasureCommand();
    UnitOfMeasureService service;

    @Mock
    UnitOfMeasureRepository unitOfMeasureRepository;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        service=new UnitOfMeasureServiceImpl(unitOfMeasureRepository,unitOfMeasureToUnitOfMeasureCommand);
    }

    @Test
    void listAllUoms() throws Exception{
        //given

        Set<UnitOfMeasure> unitOfMeasure = new HashSet<>();
        UnitOfMeasure uom1 = new UnitOfMeasure();
        uom1.setId(1L);
        unitOfMeasure.add(uom1);

        UnitOfMeasure uom2 = new UnitOfMeasure();
        uom2.setId(2L);
        unitOfMeasure.add(uom2);

        when(unitOfMeasureRepository.findAll()).thenReturn(unitOfMeasure);

        //when
        Set<UnitOfMeasureCommand> commands = service.ListAllUoms();

        //then
        assertEquals(2,commands.size());
        verify(unitOfMeasureRepository,times(1)).findAll();


    }

}