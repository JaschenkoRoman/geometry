package com.epam.geometry.logic;

import com.epam.geometry.entity.Plain;
import com.epam.geometry.entity.Cone;
import com.epam.geometry.entity.Point;
import com.epam.geometry.exception.CalculatorException;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTests {
    private static final double DELTA = 0.1d;
    private final Calculator calculator = new Calculator();
    private final Point point = new Point(-4.3, 2.5, 3.7);
    /*area tests*/
    @Test
    public void testShouldCalculateConeAreaWhenHeightIsSixAndRadiusIsThree(){
        /*Given*/
        Cone cone = new Cone(point, 6.0, 3.0);
        double expected = 91.51d;
        /*When*/
        double actual = calculator.area(cone);
        /*Then*/
        Assert.assertEquals(expected, actual, DELTA);
    }
    @Test
    public void testShouldCalculateConeAreaWhenHeightIsThreeAndRadiusIsSix(){
        /*Given*/
        Cone cone = new Cone(point, 3.0, 6.0);
        double expected = 239.575d;
        /*When*/
        double actual = calculator.area(cone);
        /*Then*/
        Assert.assertEquals(expected, actual, DELTA);
    }
    @Test
    public void testShouldCalculateConeAreaWhenHeightIsOneAndRadiusIsOne(){
        /*Given*/
        Cone cone = new Cone(point, 1.0, 1.0);
        double expected = 7.585d;
        /*When*/
        double actual = calculator.area(cone);
        /*Then*/
        Assert.assertEquals(expected, actual, DELTA);
    }
    /*Volume tests*/
    @Test
    public void testShouldCalculateConeVolumeWhenHeightIsSixAndRadiusIsThree(){
        /*Given*/
        Cone cone = new Cone(point, 6.0, 3.0);
        double expected = 56.549d;
        /*When*/
        double actual = calculator.volume(cone);
        /*Then*/
        Assert.assertEquals(expected, actual, DELTA);
    }
    @Test
    public void testShouldCalculateConeVolumeWhenHeightIsThreeAndRadiusIsSix(){
        /*Given*/
        Cone cone = new Cone(point, 3.0, 6.0);
        double expected = 113.097d;
        /*When*/
        double actual = calculator.volume(cone);
        /*Then*/
        Assert.assertEquals(expected, actual, DELTA);
    }
    @Test
    public void testShouldCalculateConeVolumeWhenHeightIsOneAndRadiusIsOne(){
        /*Given*/
        Cone cone = new Cone(point, 1.0, 1.0);
        double expected = 1.047d;
        /*When*/
        double actual = calculator.volume(cone);
        /*Then*/
        Assert.assertEquals(expected, actual, DELTA);
    }
    /*VolumeRatio tests*/
    @Test
    public void testShouldCalculateVolumeRatioWhenConeHeightIsFiveAndPlainHeightIsTwo() throws CalculatorException {
        /*Given*/
        Cone cone = new Cone(point, 5.0, 2.0);
        Plain plain = new Plain(2.0);
        double expected = 0.2755d;
        /*When*/
        double actual = calculator.volumeRatio(cone, plain);
        /*Then*/
        Assert.assertEquals(expected, actual, DELTA);
    }
    @Test(expected = CalculatorException.class)
    public void testShouldFailToCalculateVolumeRatioWhenConeHeightIsFiveAndPlainHeightIsSix() throws CalculatorException {
        /*Given*/
        Cone cone = new Cone(point, 5.0, 2.0);
        Plain plain = new Plain(6.0);
        /*When*/
       calculator.volumeRatio(cone, plain);

    }
    @Test
    public void testShouldCalculateVolumeRatioWhenConeHeightIsTwoAndPlainHeightIsOne() throws CalculatorException {
        /*Given*/
        Cone cone = new Cone(point, 2.0, 5.0);
        Plain plain = new Plain(1.0);
        double expected = 0.1428d;
        /*When*/
        double actual = calculator.volumeRatio(cone, plain);
        /*Then*/
        Assert.assertEquals(expected, actual, DELTA);
    }

    /*IsSituatedOnTheSurface tests*/
    @Test
    public void testShouldCalculateCaneIsSituatedOnTheSurfaceXY(){
        /*Given*/
        Point point = new Point(2.0,-2.0,0.0);
        Cone cone = new Cone(point, 6.0, 3.0);
        /*When*/
        boolean isSituated = calculator.isSituatedOnTheAxisSurface(cone);
        /*Then*/
        Assert.assertTrue(isSituated);
    }
    @Test
    public void testShouldCalculateCaneIsSituatedOnTheSurfaceYZ(){
        /*Given*/
        Point point = new Point(0.0,-2.0,3.0);
        Cone cone = new Cone(point, 6.0, 3.0);
        /*When*/
        boolean isSituated = calculator.isSituatedOnTheAxisSurface(cone);
        /*Then*/
        Assert.assertTrue(isSituated);
    }
    @Test
    public void testShouldCalculateCaneIsSituatedOnTheSurfaceXZ(){
        /*Given*/
        Point point = new Point(2.0,0.0,-3.0);
        Cone cone = new Cone(point, 6.0, 3.0);
        /*When*/
        boolean isSituated = calculator.isSituatedOnTheAxisSurface(cone);
        /*Then*/
        Assert.assertTrue(isSituated);
    }
    @Test
    public void testShouldCalculateCaneIsSituatedOnAllSurfaces(){
        /*Given*/
        Point point = new Point(0.0,0.0,0.0);
        Cone cone = new Cone(point, 6.0, 3.0);
        /*When*/
        boolean isSituated = calculator.isSituatedOnTheAxisSurface(cone);
        /*Then*/
        Assert.assertTrue(isSituated);
    }
    @Test
    public void testShouldCalculateCaneIsNotSituatedOnAnySurface(){
        /*Given*/
        Point point = new Point(2.0,-2.0,5.0);
        Cone cone = new Cone(point, 6.0, 3.0);
        /*When*/
        boolean isSituated = calculator.isSituatedOnTheAxisSurface(cone);
        /*Then*/
        Assert.assertFalse(isSituated);
    }

}
