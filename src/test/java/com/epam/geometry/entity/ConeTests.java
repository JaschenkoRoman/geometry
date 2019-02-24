package com.epam.geometry.entity;

import com.epam.geometry.exception.ConeCreationException;
import org.junit.Assert;
import org.junit.Test;

public class ConeTests {
    private static final double DELTA = 0.01d;
    private final Point point = new Point(-4.3, 2.5, 3.7);

    /*positive tests*/
    @Test
    public void testConeShouldCreateConeWhenHeightIsSixAndRadiusIsTwoDotThree() {
        /*When*/
        Cone actual = new Cone(point, 6.0, 2.3);
        /*Then*/
        double height = actual.getHeight();
        double radius = actual.getRadius();
        Assert.assertEquals(6.0 , height,DELTA);
        Assert.assertEquals(2.3, radius, DELTA);
    }
    @Test
    public void testConeShouldCreateConeWhenHeightIsOneDotOneAndRadiusIsThreeDotSeven() {
        /*When*/
        Cone actual = new Cone(point, 0.1, 3.7);
        /*Then*/
        double height = actual.getHeight();
        double radius = actual.getRadius();
        Assert.assertEquals(0.1 , height, DELTA);
        Assert.assertEquals(3.7, radius, DELTA);
    }
    @Test
    public void testConeShouldCreateConeWhenHeightIsTenDotTwoAndRadiusIsOneDotOne() {
        /*When*/
        Cone actual = new Cone(point, 10.2, 0.1);
        /*Then*/
        double height = actual.getHeight();
        double radius = actual.getRadius();
        Assert.assertEquals(10.2 , height,DELTA);
        Assert.assertEquals(0.1, radius, DELTA);
    }
    @Test
    public void testConeShouldCreateConeWhenHeightIsOneDotOneAndRadiusIsOneDotOne() {
        /*When*/
        Cone actual = new Cone(point, 0.1, 0.1);
        /*Then*/
        double height = actual.getHeight();
        double radius = actual.getRadius();
        Assert.assertEquals(0.1 , height, DELTA);
        Assert.assertEquals(0.1, radius, DELTA);
    }
    /*negative tests*/
    @Test(expected = ConeCreationException.class)
    public void testConeShouldFailToCreateConeWhenZeroHeightAndZeroRadius(){
        new Cone(point, 0.0, 0.0);
    }
    @Test(expected = ConeCreationException.class)
    public void testConeShouldFailToCreateConeWhenHeightIsNegativeAndRadiusIsPositive(){
        new Cone(point, -0.1, 0.1);
    }
    @Test(expected = ConeCreationException.class)
    public void testConeShouldFailToCreateConeWhenHeightIsNegativeAndRadiusIsZero(){
        new Cone(point, -0.1, 0.0);
    }
    @Test(expected = ConeCreationException.class)
    public void testConeShouldFailToCreateConeWhenZeroHeightAndNegativeRadius() {
        new Cone(point, 0.0, -0.1);
    }
    @Test(expected = ConeCreationException.class)
    public void testConeShouldFailToCreateConeWhenZeroHeightAndPositiveRadius(){
        new Cone(point, 0.0, 0.1);
    }
    @Test(expected = ConeCreationException.class)
    public void testConeShouldFailToCreateConeWhenPositiveHeightAndZeroRadius(){
        new Cone(point, 0.1, 0.0);
    }

}
