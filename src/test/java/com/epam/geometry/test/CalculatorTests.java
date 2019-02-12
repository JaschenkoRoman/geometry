package com.epam.geometry.test;

import com.epam.geometry.entity.Plain;
import com.epam.geometry.logic.Calculator;
import com.epam.geometry.entity.Cone;
import com.epam.geometry.entity.Point;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTests {
    private static final double DELTA = 0.1d;
    private final Calculator calculator = new Calculator();
    private final Point pointMock = new Point(-4.3, 2.5, 3.7);
    /*SurfaceSquare tests*/
    @Test
    public void calculateConeSurfaceSquareWhenHeightIsSixAndRadiusIsThree(){
        Cone cone = new Cone(pointMock, 6.0, 3.0);
        double actual = calculator.surfaceSquare(cone);
        double expected = 91.51d;
        Assert.assertEquals(expected, actual, DELTA);
    }
    @Test
    public void calculateConeSurfaceSquareWhenHeightIsThreeAndRadiusIsSix(){
        Cone cone = new Cone(pointMock, 3.0, 6.0);
        double actual = calculator.surfaceSquare(cone);
        double expected = 239.575d;
        Assert.assertEquals(expected, actual, DELTA);
    }
    @Test
    public void calculateConeSurfaceSquareWhenHeightIsOneAndRadiusIsOne(){
        Cone cone = new Cone(pointMock, 1.0, 1.0);
        double actual = calculator.surfaceSquare(cone);
        double expected = 7.585d;
        Assert.assertEquals(expected, actual, DELTA);
    }
    /*Volume tests*/
    @Test
    public void calculateConeVolumeWhenHeightIsSixAndRadiusIsThree(){
        Cone cone = new Cone(pointMock, 6.0, 3.0);
        double actual = calculator.volume(cone);
        double expected = 56.549d;
        Assert.assertEquals(expected, actual, DELTA);
    }
    @Test
    public void calculateConeVolumeWhenHeightIsThreeAndRadiusIsSix(){
        Cone cone = new Cone(pointMock, 3.0, 6.0);
        double actual = calculator.volume(cone);
        double expected = 113.097d;
        Assert.assertEquals(expected, actual, DELTA);
    }
    @Test
    public void calculateConeVolumeWhenHeightIsOneAndRadiusIsOne(){
        Cone cone = new Cone(pointMock, 1.0, 1.0);
        double actual = calculator.volume(cone);
        double expected = 1.047d;
        Assert.assertEquals(expected, actual, DELTA);
    }
    /*VolumeRatio tests*/
    @Test
    public void calculateVolumeRatioWhenConeHeightIsFiveAndPlainHeightIsTwo(){
        Cone cone = new Cone(pointMock, 5.0, 2.0);
        Plain plain = new Plain(2.0);
        double expected = 0.2755d;
        double actual = calculator.volumeRatio(cone, plain);
        Assert.assertEquals(expected, actual, DELTA);
    }
    @Test
    public void calculateVolumeRatioWhenConeHeightIsFiveAndPlainHeightIsSix(){
        Cone cone = new Cone(pointMock, 5.0, 2.0);
        Plain plain = new Plain(6.0);
        double expected = -1;
        double actual = calculator.volumeRatio(cone, plain);
        Assert.assertEquals(expected, actual, DELTA);
    }
    @Test
    public void calculateVolumeRatioWhenConeHeightIsTwoAndPlainHeightIsOne(){
        Cone cone = new Cone(pointMock, 2.0, 5.0);
        Plain plain = new Plain(1.0);
        double expected = 0.1428d;
        double actual = calculator.volumeRatio(cone, plain);
        Assert.assertEquals(expected, actual, DELTA);
    }

    /*IsSituatedOnTheSurface tests*/
    @Test
    public void caneIsSituatedOnTheSurfaceXY(){
        Point point = new Point(2.0,-2.0,0.0);
        Cone cone = new Cone(point, 6.0, 3.0);
        Assert.assertTrue(calculator.isSituatedOnTheAxisSurface(cone));
    }
    @Test
    public void caneIsSituatedOnTheSurfaceYZ(){
        Point point = new Point(0.0,-2.0,3.0);
        Cone cone = new Cone(point, 6.0, 3.0);
        Assert.assertTrue(calculator.isSituatedOnTheAxisSurface(cone));
    }
    @Test
    public void caneIsSituatedOnTheSurfaceXZ(){
        Point point = new Point(2.0,0.0,-3.0);
        Cone cone = new Cone(point, 6.0, 3.0);
        Assert.assertTrue(calculator.isSituatedOnTheAxisSurface(cone));
    }
    @Test
    public void caneIsSituatedOnAllSurfaces(){
        Point point = new Point(0.0,0.0,0.0);
        Cone cone = new Cone(point, 6.0, 3.0);
        Assert.assertTrue(calculator.isSituatedOnTheAxisSurface(cone));
    }
    @Test
    public void caneIsNotSituatedOnAnySurface(){
        Point point = new Point(2.0,-2.0,5.0);
        Cone cone = new Cone(point, 6.0, 3.0);
        Assert.assertFalse(calculator.isSituatedOnTheAxisSurface(cone));
    }

}
