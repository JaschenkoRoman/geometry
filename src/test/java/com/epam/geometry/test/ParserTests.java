package com.epam.geometry.test;

import com.epam.geometry.exception.ParseException;
import com.epam.geometry.parser.ConeParser;
import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

public class ParserTests {
    private final ConeParser coneParser = new ConeParser();
    
    private void compareLists(List<double[]> expected, List<double[]> actual){
        for (int i = 0; i < expected.size(); i++) {
            String expectedArray = Arrays.toString(expected.get(i));
            String actualArray = Arrays.toString(actual.get(i));
            Assert.assertEquals(expectedArray, actualArray);
        } 
    }

    @Test
    public void AllStringsHaveAllFiveElementsAsDouble() throws ParseException{
        List<double[]> expected = Arrays.asList(
                new double[]{11.0, 3.0, 2.0, 1.0, 1.0},
                new double[]{-2.0, 2.0, 2.0, 5.0, 7.0},
                new double[]{4.0, -5.0, -5.0, 2.0, 4.0});
        List<double[]> actual = coneParser.parse(Arrays.asList(
                "11.0 3.0 2.0 1.0 1.0",
                "-2.0 2.0 2.0 5.0 7.0",
                "4.0 -5.0 -5.0 2.0 4.0"));
        compareLists(expected, actual);
    }
    @Test
    public void EachStringHasMoreThanFiveElementsAsDouble() throws ParseException {
        List<double[]> expected = Arrays.asList(
                new double[]{11.0, 3.0, 2.0, 1.0, 1.0},
                new double[]{-2.0, 2.0, 2.0, 5.0, 7.0},
                new double[]{4.0, -5.0, -5.0, 2.0, 4.0});
        List<double[]> actual = coneParser.parse(Arrays.asList(
                "11.0 3.0 2.0 1.0 1.0 2.1 4.0",
                "-2.0 2.0 2.0 5.0 7.0 6.6 1.0",
                "4.0 -5.0 -5.0 2.0 4.0 2.2"));
        compareLists(expected, actual);
    }
    @Test
    public void SecondStringHasFourElementsAsDouble() throws ParseException {
        List<double[]> expected = Arrays.asList(
                new double[]{11.0, 3.0, 2.0, 1.0, 1.0},
                new double[]{4.0, -5.0, -5.0, 2.0, 4.0});
        List<double[]> actual = coneParser.parse(Arrays.asList(
                "11.0 3.0 2.0 1.0 1.0",
                "-2.0 2.0 2.0 5.0",
                "4.0 -5.0 -5.0 2.0 4.0"));
        compareLists(expected, actual);
    }
    @Test
    public void ThirdStringHasThreeElementsAsDouble() throws ParseException {
        List<double[]> expected = Arrays.asList(
                new double[]{11.0, 3.0, 2.0, 1.0, 1.0},
                new double[]{-2.0, 2.0, 2.0, 5.0, 7.0});
        List<double[]> actual = coneParser.parse(Arrays.asList(
                "11.0 3.0 2.0 1.0 1.0",
                "-2.0 2.0 2.0 5.0 7.0",
                "4.0 -5.0 -5.0"));
        compareLists(expected, actual);
    }

    @Test
    public void SecondStringHasFirstElementAsNotDouble() throws ParseException {
        List<double[]> expected = Arrays.asList(
                new double[]{11.0, 3.0, 2.0, 1.0, 1.0},
                new double[]{4.0, -5.0, -5.0, 2.0, 4.0});
        List<double[]> actual = coneParser.parse(Arrays.asList(
                "11.0 3.0 2.0 1.0 1.0",
                "-2.0abc 2.0 2.0 5.0 7.0",
                "4.0 -5.0 -5.0 2.0 4.0"));
        compareLists(expected, actual);
    }
    @Test
    public void FirstStringHasFirstElementAsDoubleOthersAsNotDouble() throws ParseException {
        List<double[]> expected = Arrays.asList(
                new double[]{-2.0, 2.0, 2.0, 5.0, 7.0},
                new double[]{4.0, -5.0, -5.0, 2.0, 4.0});
        List<double[]> actual = coneParser.parse(Arrays.asList(
                "11.0 3.0asd 2.0as 1.044#$ 1.0%3$",
                "-2.0 2.0 2.0 5.0 7.0",
                "4.0 -5.0 -5.0 2.0 4.0"));
        compareLists(expected, actual);
    }
    @Test
    public void ThirdStringHasFirstAndSecondElementAsDoubleOthersAsNotDouble() throws ParseException {
        List<double[]> expected = Arrays.asList(
                new double[]{11.0, 3.0, 2.0, 1.0, 1.0},
                new double[]{-2.0, 2.0, 2.0, 5.0, 7.0});
        List<double[]> actual = coneParser.parse(Arrays.asList(
                "11.0 3.0 2.0 1.0 1.0",
                "-2.0 2.0 2.0 5.0 7.0",
                "4.0 -5.0 -5.0## 2.03$ 4.0#41v"));
        compareLists(expected, actual);
    }
    @Test
    public void SecondStringHasThirdElementAsNotDoubleOthersAsDouble() throws ParseException {
        List<double[]> expected = Arrays.asList(
                new double[]{11.0, 3.0, 2.0, 1.0, 1.0},
                new double[]{4.0, -5.0, -5.0, 2.0, 4.0});
        List<double[]> actual = coneParser.parse(Arrays.asList(
                "11.0 3.0 2.0 1.0 1.0",
                "-2.0 2.0 2.0##f2 5.0 7.0",
                "4.0 -5.0 -5.0 2.0 4.0"));
        compareLists(expected, actual);
    }
    @Test
    public void FirstStringHasFourthElementAsNotDoubleOthersAsDouble() throws ParseException {
        List<double[]> expected = Arrays.asList(
                new double[]{-2.0, 2.0, 2.0, 5.0, 7.0},
                new double[]{4.0, -5.0, -5.0, 2.0, 4.0});
        List<double[]> actual = coneParser.parse(Arrays.asList(
                "11.0 3.0 2.0 1sad2!.0 1.0",
                "-2.0 2.0 2.0 5.0 7.0",
                "4.0 -5.0 -5.0 2.0 4.0"));
        compareLists(expected, actual);
    }
    @Test
    public void ThirdStringHasFifthElementAsNotDoubleOthersAsDouble() throws ParseException {
        List<double[]> expected = Arrays.asList(
                new double[]{11.0, 3.0, 2.0, 1.0, 1.0},
                new double[]{-2.0, 2.0, 2.0, 5.0, 7.0});
        List<double[]> actual = coneParser.parse(Arrays.asList(
                "11.0 3.0 2.0 1.0 1.0",
                "-2.0 2.0 2.0 5.0 7.0",
                "4.0 -5.0 -5.0 2.0 4.0sdq@.2"));
        compareLists(expected, actual);
    }
    @Test
    public void FirstStringHasFourthElementAsNotDoubleOthersMoreThanFiveAsDouble() throws ParseException {
        List<double[]> expected = Arrays.asList(
                new double[]{-2.0, 2.0, 2.0, 5.0, 7.0},
                new double[]{4.0, -5.0, -5.0, 2.0, 4.0});
        List<double[]> actual = coneParser.parse(Arrays.asList(
                "11.0 3.0 2.0 1sad2!.0 1.0 2.2 3.3",
                "-2.0 2.0 2.0 5.0 7.0",
                "4.0 -5.0 -5.0 2.0 4.0"));
        compareLists(expected, actual);
    }
    @Test(expected = ParseException.class)
    public void FileIsEmptyIsInvalid() throws ParseException {
        coneParser.parse(Arrays.asList("", "", ""));
    }
    @Test(expected = ParseException.class)
    public void SingleStringIsIncorrectIsInvalid() throws ParseException {
        coneParser.parse(Arrays.asList("", "2.0 3.2 4df%#.f2 4.5 34.4", ""));
    }
}
