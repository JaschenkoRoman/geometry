package com.epam.geometry.director;

import com.epam.geometry.entity.Cone;
import com.epam.geometry.entity.Point;
import com.epam.geometry.exception.DataException;
import com.epam.geometry.exception.ParseException;
import com.epam.geometry.parser.DataParser;
import com.epam.geometry.reader.DataReader;
import com.epam.geometry.validator.ConeValidator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;

public class ConeDirectorTests {
    private DataReader reader = mock(DataReader.class);
    private final DataParser parser =  mock(DataParser.class);
    private final ConeValidator validator = mock(ConeValidator.class);

    @Test
    public void testConeDirectorShouldProcessWhenCorrectParameters() throws DataException, ParseException {
        /*Given*/
        when(reader.readLines()).thenReturn(Arrays.asList(
                "1.0 1.0 2.0 3.1 3.4ss",
                "",
                "4.0 -2.2 0.0 1.8 3.4 2.2",
                "-3.1 1.3 -5.5 3.3 0.8"
                )
        );
        when(parser.parse(anyList())).thenReturn(Arrays.asList(
                new double[]{4.0, -2.2, 0.0, 1.8, 3.4},
                new double[]{-3.1, 1.3, -5.5, 3.3, 0.8}
                )
        );
        when(validator.isCone(any(double[].class))).thenReturn(true).thenReturn(true);
        List<Cone> expectedList = Arrays.asList(
                new Cone(new Point(4.0, -2.2, 0.0), 1.8, 3.4),
                new Cone(new Point(-3.1, 1.3, -5.5), 3.3, 0.8)
        );
        ConeDirector coneDirector = new ConeDirector(reader, parser, validator);
        /*When*/
        List<Cone> actualList = coneDirector.process();
        /*Then*/
        String expected = Arrays.toString(expectedList.toArray());
        String actual = Arrays.toString(actualList.toArray());
        Assert.assertNotNull(actualList);
        Assert.assertEquals(expected, actual);
        verify(reader).readLines();
        verify(parser).parse(anyList());
        verify(validator, times(2)).isCone(any(double[].class));
        verifyNoMoreInteractions(reader);
        verifyNoMoreInteractions(parser);
        verifyNoMoreInteractions(validator);

    }
    @Test(expected = DataException.class)
    public void testConeDirectorShouldFailToProcessWhenDataReaderThrowsDataException() throws DataException, ParseException {
        /*Given*/
        when(reader.readLines()).thenThrow(DataException.class);
        ConeDirector coneDirector = new ConeDirector(reader, parser, validator);
        /*When*/
        coneDirector.process();
    }
    @Test(expected = ParseException.class)
    public void testConeDirectorShouldFailToProcessWhenParserThrowsParserException() throws DataException, ParseException {
        /*Given*/
        when(reader.readLines()).thenReturn(Arrays.asList("", "", ""));
        when(parser.parse(anyList())).thenThrow(ParseException.class);
        ConeDirector coneDirector = new ConeDirector(reader, parser, validator);
        /*When*/
       coneDirector.process();
    }

}
