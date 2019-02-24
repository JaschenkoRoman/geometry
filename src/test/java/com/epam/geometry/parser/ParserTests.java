package com.epam.geometry.parser;

import com.epam.geometry.exception.ParseException;
import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class ParserTests {
    private final ConeParser coneParser = new ConeParser();

    @Test
    public void testShouldParseWhenAllStringsHaveAllFiveElementsAsDouble() throws ParseException {
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
        assertThat(actual, IsIterableContainingInOrder.contains(expected.toArray()));
        assertThat(expected, IsIterableContainingInOrder.contains(actual.toArray()));
    }
    @Test
    public void testShouldParseWhenEachStringHasMoreThanFiveElementsAsDouble() throws ParseException {
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
        assertThat(actual, IsIterableContainingInOrder.contains(expected.toArray()));
        assertThat(expected, IsIterableContainingInOrder.contains(actual.toArray()));
    }
    @Test
    public void testShouldParseWhenSecondStringHasFourElementsAsDouble() throws ParseException {
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
        assertThat(actual, IsIterableContainingInOrder.contains(expected.toArray()));
        assertThat(expected, IsIterableContainingInOrder.contains(actual.toArray()));
    }
    @Test
    public void testShouldParseWhenThirdStringHasThreeElementsAsDouble() throws ParseException {
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
        assertThat(actual, IsIterableContainingInOrder.contains(expected.toArray()));
        assertThat(expected, IsIterableContainingInOrder.contains(actual.toArray()));
    }

    @Test
    public void testShouldParseWhenSecondStringHasFirstElementAsNotDouble() throws ParseException {
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
        assertThat(actual, IsIterableContainingInOrder.contains(expected.toArray()));
        assertThat(expected, IsIterableContainingInOrder.contains(actual.toArray()));
    }
    @Test
    public void testShouldParseWhenFirstStringHasFirstElementAsDoubleOthersAsNotDouble() throws ParseException {
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
        assertThat(actual, IsIterableContainingInOrder.contains(expected.toArray()));
        assertThat(expected, IsIterableContainingInOrder.contains(actual.toArray()));
    }
    @Test
    public void testShouldParseWhenThirdStringHasFirstAndSecondElementAsDoubleOthersAsNotDouble() throws ParseException {
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
        assertThat(actual, IsIterableContainingInOrder.contains(expected.toArray()));
        assertThat(expected, IsIterableContainingInOrder.contains(actual.toArray()));
    }
    @Test
    public void testShouldParseWhenSecondStringHasThirdElementAsNotDoubleOthersAsDouble() throws ParseException {
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
        assertThat(actual, IsIterableContainingInOrder.contains(expected.toArray()));
        assertThat(expected, IsIterableContainingInOrder.contains(actual.toArray()));
    }
    @Test
    public void testShouldParseWhenFirstStringHasFourthElementAsNotDoubleOthersAsDouble() throws ParseException {
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
        assertThat(actual, IsIterableContainingInOrder.contains(expected.toArray()));
        assertThat(expected, IsIterableContainingInOrder.contains(actual.toArray()));
    }
    @Test
    public void testShouldParseWhenThirdStringHasFifthElementAsNotDoubleOthersAsDouble() throws ParseException {
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
        assertThat(actual, IsIterableContainingInOrder.contains(expected.toArray()));
        assertThat(expected, IsIterableContainingInOrder.contains(actual.toArray()));
    }
    @Test
    public void testShouldParseWhenFirstStringHasFourthElementAsNotDoubleOthersMoreThanFiveAsDouble() throws ParseException {
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
        assertThat(actual, IsIterableContainingInOrder.contains(expected.toArray()));
        assertThat(expected, IsIterableContainingInOrder.contains(actual.toArray()));
    }
    @Test(expected = ParseException.class)
    public void testShouldFailToParseWhenFileIsEmpty() throws ParseException {
        coneParser.parse(Arrays.asList(""));
    }
    @Test(expected = ParseException.class)
    public void testShouldFailToParseWhenSingleStringIsIncorrect() throws ParseException {
        coneParser.parse(Arrays.asList("2.0 3.2 4df%#.f2 4.5 34.4"));
    }
}
