package com.epam.geometry.reader;

import com.epam.geometry.exception.DataException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ReaderTests {
    private DataReader reader;
    @Test
    public void testShouldReadWhenPathIsCorrect() throws DataException {
        /*Given*/
        String path = "src/test/resources/readerInput.txt";
        List<String> expectedList = Arrays.asList(
                "11.0 3.0 2.0 1.0 1.0",
                "-2.0 2.0 2.0 5.0 7.0",
                "4.0 -5.0 -5.0 2.0 4.0"
        );
        reader = new DataReaderImpl(path);
        /*When*/
        List<String> actualList = reader.readLines();
        /*Then*/
        Assert.assertNotNull(actualList);
        Assert.assertEquals(actualList, expectedList);
    }
    @Test(expected = DataException.class)
    public void testShouldFailToReadWhenPathIsEmpty() throws DataException {
        String path = "";
        reader = new DataReaderImpl(path);
        reader.readLines();
    }
    @Test(expected = DataException.class)
    public void testShouldFailToReadWhenPathIsIncorrect() throws DataException {
        String path = "Wde://fil@wefefe.txt";
        reader = new DataReaderImpl(path);
        reader.readLines();
    }
    @Test(expected = DataException.class)
    public void testShouldFailToReadWhenFileDoesNotExist() throws DataException {
        String path = "src/test/resources/reader.txt";
        reader = new DataReaderImpl(path);
        reader.readLines();
    }
}
