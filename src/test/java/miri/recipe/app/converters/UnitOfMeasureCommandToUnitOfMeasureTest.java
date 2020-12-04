package miri.recipe.app.converters;

import miri.recipe.app.commands.UnitOfMeasureCommand;
import miri.recipe.app.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.security.krb5.internal.crypto.Des;

import static org.junit.jupiter.api.Assertions.*;

class UnitOfMeasureCommandToUnitOfMeasureTest {

    public static final String DESCRIPTION = "description";
    public static final Long LONG_VALUE= new Long(1l);

    UnitOfMeasureCommandToUnitOfMeasure converter;

    @BeforeEach
    void setUp() throws Exception{
        converter=new UnitOfMeasureCommandToUnitOfMeasure();
    }

    //always good to test null parameter
    @Test
    public void testNullParam()throws Exception{
        assertNotNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject()throws Exception{
        assertNotNull(converter.convert(new UnitOfMeasureCommand()));
    }



    @Test
    void convert() throws Exception{

        //given
        UnitOfMeasureCommand command =  new UnitOfMeasureCommand();
        command.setId(LONG_VALUE);
        command.setDescription(DESCRIPTION);

        //when
        UnitOfMeasure uom =converter.convert(command);

        //then
        assertNotNull(uom);
        assertEquals(LONG_VALUE,uom.getId());
        assertEquals(DESCRIPTION,uom.getDescription());
    }

}