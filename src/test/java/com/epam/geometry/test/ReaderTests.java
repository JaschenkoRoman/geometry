package com.epam.geometry.test;

import com.epam.geometry.exception.DataException;
import com.epam.geometry.reader.DataReader;
import com.epam.geometry.reader.DataReaderImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ReaderTests {
    private DataReader readerMock;
    @Test
    public void ReadWhenPathIsCorrectIsValid() throws DataException {
        String path = "src/test/resources/readerInput.txt";
        readerMock = new DataReaderImpl(path);
        List<String> actualList = readerMock.readLines();
        List<String> expectedList = Arrays.asList(
                "11.0 3.0 2.0 1.0 1.0",
                "-2.0 2.0 2.0 5.0 7.0",
                "4.0 -5.0 -5.0 2.0 4.0");
        Assert.assertEquals(actualList, expectedList);
    }
    @Test(expected = DataException.class)
    public void FailToReadWhenPathIsEmptyIsInvalid() throws DataException {
        String path = "";
        readerMock = new DataReaderImpl(path);
        readerMock.readLines();
    }
    @Test(expected = DataException.class)
    public void FailToReadWhenPathIsIncorrectIsInvalid() throws DataException {
        String path = "Wde://fil@wefefe.txt";
        readerMock = new DataReaderImpl(path);
        readerMock.readLines();
    }
    @Test(expected = DataException.class)
    public void FailToReadWhenFileDoesNotExistIsInvalid() throws DataException {
        String path = "src/test/resources/reader.txt";
        readerMock = new DataReaderImpl(path);
        readerMock.readLines();
    }
}
