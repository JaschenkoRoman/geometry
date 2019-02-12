package com.epam.geometry.test;

import com.epam.geometry.director.ConeDirector;
import com.epam.geometry.entity.Cone;
import com.epam.geometry.entity.Point;
import com.epam.geometry.exception.DataException;
import com.epam.geometry.exception.ParseException;
import com.epam.geometry.parser.ConeParser;
import com.epam.geometry.parser.DataParser;
import com.epam.geometry.reader.DataReader;
import com.epam.geometry.validator.ConeValidator;
import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ConeDirectorTests {
    private final DataParser parser = new ConeParser();
    private final ConeValidator validator = new ConeValidator();

    @Test
    public void processConeDirectorWithCorrectParameters() throws DataException, ParseException {
        DataReader reader = mock(DataReader.class);
        when(reader.readLines()).thenReturn(Arrays.asList(
                "1.0 1.0 2.0 3.1 3.4ss",
                "",
                "4.0 -2.2 0.0 1.8 3.4 2.2",
                "-3.1 1.3 -5.5 3.3 0.8"));
        List<Cone> expectedList = Arrays.asList(
                new Cone(new Point(4.0, -2.2, 0.0), 1.8, 3.4),
                new Cone(new Point(-3.1, 1.3, -5.5), 3.3, 0.8));
        ConeDirector coneDirector = new ConeDirector(reader, parser, validator);
        List<Cone> actualList = coneDirector.process();
        String expected = Arrays.toString(expectedList.toArray());
        String actual = Arrays.toString(actualList.toArray());
        Assert.assertEquals(expected, actual);

    }
}
