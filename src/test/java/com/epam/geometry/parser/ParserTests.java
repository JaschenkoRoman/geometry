package com.epam.geometry.parser;

import com.epam.geometry.exception.ParseException;
import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

public class ParserTests {
    private final ConeParser coneParser = new ConeParser();
    
    private void assertEqualsLists(List<double[]> expected, List<double[]> actual){
        for (int i = 0; i < expected.size(); i++) {
            String expectedArray = Arrays.toString(expected.get(i));
            String actualArray = Arrays.toString(actual.get(i));
            Assert.assertEquals(expectedArray, actualArray);
        } 
    }

    @Test
    public void ShouldParseWhenAllStringsHaveAllFiveElementsAsDouble() throws ParseException{
        /*Given*/
        List<double[]> expected = Arrays.asList(
                new double[]{11.0, 3.0, 2.0, 1.0, 1.0},
                new double[]{-2.0, 2.0, 2.0, 5.0, 7.0},
                new double[]{4.0, -5.0, -5.0, 2.0, 4.0});
        /*When*/
        List<double[]> actual = coneParser.parse(Arrays.asList(
                "11.0 3.0 2.0 1.0 1.0",
                "-2.0 2.0 2.0 5.0 7.0",
                "4.0 -5.0 -5.0 2.0 4.0"));
        /*Then*/
        Assert.assertNotNull(actual);
        assertEqualsLists(expected, actual);
    }
    @Test
    public void ShouldParseWhenEachStringHasMoreThanFiveElementsAsDouble() throws ParseException {
        /*Given*/
        List<double[]> expected = Arrays.asList(
                new double[]{11.0, 3.0, 2.0, 1.0, 1.0},
                new double[]{-2.0, 2.0, 2.0, 5.0, 7.0},
                new double[]{4.0, -5.0, -5.0, 2.0, 4.0});
        /*When*/
        List<double[]> actual = coneParser.parse(Arrays.asList(
                "11.0 3.0 2.0 1.0 1.0 2.1 4.0",
                "-2.0 2.0 2.0 5.0 7.0 6.6 1.0",
                "4.0 -5.0 -5.0 2.0 4.0 2.2"));
        /*Then*/
        Assert.assertNotNull(actual);
        assertEqualsLists(expected, actual);
    }
    @Test
    public void ShouldParseWhenSecondStringHasFourElementsAsDouble() throws ParseException {
        /*Given*/
        List<double[]> expected = Arrays.asList(
                new double[]{11.0, 3.0, 2.0, 1.0, 1.0},
                new double[]{4.0, -5.0, -5.0, 2.0, 4.0});
        /*When*/
        List<double[]> actual = coneParser.parse(Arrays.asList(
                "11.0 3.0 2.0 1.0 1.0",
                "-2.0 2.0 2.0 5.0",
                "4.0 -5.0 -5.0 2.0 4.0"));
        /*Then*/
        Assert.assertNotNull(actual);
        assertEqualsLists(expected, actual);
    }
    @Test
    public void ShouldParseWhenThirdStringHasThreeElementsAsDouble() throws ParseException {
        /*Given*/
        List<double[]> expected = Arrays.asList(
                new double[]{11.0, 3.0, 2.0, 1.0, 1.0},
                new double[]{-2.0, 2.0, 2.0, 5.0, 7.0});
        /*When*/
        List<double[]> actual = coneParser.parse(Arrays.asList(
                "11.0 3.0 2.0 1.0 1.0",
                "-2.0 2.0 2.0 5.0 7.0",
                "4.0 -5.0 -5.0"));
        /*Then*/
        Assert.assertNotNull(actual);
        assertEqualsLists(expected, actual);
    }

    @Test
    public void ShouldParseWhenSecondStringHasFirstElementAsNotDouble() throws ParseException {
        /*Given*/
        List<double[]> expected = Arrays.asList(
                new double[]{11.0, 3.0, 2.0, 1.0, 1.0},
                new double[]{4.0, -5.0, -5.0, 2.0, 4.0});
        /*When*/
        List<double[]> actual = coneParser.parse(Arrays.asList(
                "11.0 3.0 2.0 1.0 1.0",
                "-2.0abc 2.0 2.0 5.0 7.0",
                "4.0 -5.0 -5.0 2.0 4.0"));
        /*Then*/
        Assert.assertNotNull(actual);
        assertEqualsLists(expected, actual);
    }
    @Test
    public void ShouldParseWhenFirstStringHasFirstElementAsDoubleOthersAsNotDouble() throws ParseException {
        /*Given*/
        List<double[]> expected = Arrays.asList(
                new double[]{-2.0, 2.0, 2.0, 5.0, 7.0},
                new double[]{4.0, -5.0, -5.0, 2.0, 4.0});
        /*When*/
        List<double[]> actual = coneParser.parse(Arrays.asList(
                "11.0 3.0asd 2.0as 1.044#$ 1.0%3$",
                "-2.0 2.0 2.0 5.0 7.0",
                "4.0 -5.0 -5.0 2.0 4.0"));
        /*Then*/
        Assert.assertNotNull(actual);
        assertEqualsLists(expected, actual);
    }
    @Test
    public void ShouldParseWhenThirdStringHasFirstAndSecondElementAsDoubleOthersAsNotDouble() throws ParseException {
        /*Given*/
        List<double[]> expected = Arrays.asList(
                new double[]{11.0, 3.0, 2.0, 1.0, 1.0},
                new double[]{-2.0, 2.0, 2.0, 5.0, 7.0});
        /*When*/
        List<double[]> actual = coneParser.parse(Arrays.asList(
                "11.0 3.0 2.0 1.0 1.0",
                "-2.0 2.0 2.0 5.0 7.0",
                "4.0 -5.0 -5.0## 2.03$ 4.0#41v"));
        /*Then*/
        Assert.assertNotNull(actual);
        assertEqualsLists(expected, actual);
    }
    @Test
    public void ShouldParseWhenSecondStringHasThirdElementAsNotDoubleOthersAsDouble() throws ParseException {
        /*Given*/
        List<double[]> expected = Arrays.asList(
                new double[]{11.0, 3.0, 2.0, 1.0, 1.0},
                new double[]{4.0, -5.0, -5.0, 2.0, 4.0});
        /*When*/
        List<double[]> actual = coneParser.parse(Arrays.asList(
                "11.0 3.0 2.0 1.0 1.0",
                "-2.0 2.0 2.0##f2 5.0 7.0",
                "4.0 -5.0 -5.0 2.0 4.0"));
        /*Then*/
        Assert.assertNotNull(actual);
        assertEqualsLists(expected, actual);
    }
    @Test
    public void ShouldParseWhenFirstStringHasFourthElementAsNotDoubleOthersAsDouble() throws ParseException {
        /*Given*/
        List<double[]> expected = Arrays.asList(
                new double[]{-2.0, 2.0, 2.0, 5.0, 7.0},
                new double[]{4.0, -5.0, -5.0, 2.0, 4.0});
        /*When*/
        List<double[]> actual = coneParser.parse(Arrays.asList(
                "11.0 3.0 2.0 1sad2!.0 1.0",
                "-2.0 2.0 2.0 5.0 7.0",
                "4.0 -5.0 -5.0 2.0 4.0"));
        /*Then*/
        Assert.assertNotNull(actual);
        assertEqualsLists(expected, actual);
    }
    @Test
    public void ShouldParseWhenThirdStringHasFifthElementAsNotDoubleOthersAsDouble() throws ParseException {
        /*Given*/
        List<double[]> expected = Arrays.asList(
                new double[]{11.0, 3.0, 2.0, 1.0, 1.0},
                new double[]{-2.0, 2.0, 2.0, 5.0, 7.0});
        /*When*/
        List<double[]> actual = coneParser.parse(Arrays.asList(
                "11.0 3.0 2.0 1.0 1.0",
                "-2.0 2.0 2.0 5.0 7.0",
                "4.0 -5.0 -5.0 2.0 4.0sdq@.2"));
        /*Then*/
        Assert.assertNotNull(actual);
        assertEqualsLists(expected, actual);
    }
    @Test
    public void ShouldParseWhenFirstStringHasFourthElementAsNotDoubleOthersMoreThanFiveAsDouble() throws ParseException {
        /*Given*/
        List<double[]> expected = Arrays.asList(
                new double[]{-2.0, 2.0, 2.0, 5.0, 7.0},
                new double[]{4.0, -5.0, -5.0, 2.0, 4.0});
        /*When*/
        List<double[]> actual = coneParser.parse(Arrays.asList(
                "11.0 3.0 2.0 1sad2!.0 1.0 2.2 3.3",
                "-2.0 2.0 2.0 5.0 7.0",
                "4.0 -5.0 -5.0 2.0 4.0"));
        /*Then*/
        Assert.assertNotNull(actual);
        assertEqualsLists(expected, actual);
    }
    @Test(expected = ParseException.class)
    public void ShouldFailToParseWhenFileIsEmpty() throws ParseException {
        coneParser.parse(Arrays.asList(""));
    }
    @Test(expected = ParseException.class)
    public void ShouldFailToParseWhenSingleStringIsIncorrect() throws ParseException {
        coneParser.parse(Arrays.asList("2.0 3.2 4df%#.f2 4.5 34.4"));
    }
}
