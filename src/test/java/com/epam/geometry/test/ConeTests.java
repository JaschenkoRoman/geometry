package com.epam.geometry.test;

import com.epam.geometry.entity.Cone;
import com.epam.geometry.entity.Point;
import com.epam.geometry.exception.ConeCreationException;
import org.junit.Assert;
import org.junit.Test;

public class ConeTests {
    private static final double DELTA = 0.1d;
    private final Point pointMock = new Point(-4.3, 2.5, 3.7);

    /*positive tests*/
    @Test
    public void createConeWhenHeightIsSixAndRadiusIsTwoDotThreeIsValid(){
        Cone actual = new Cone(pointMock, 6.0, 2.3);
        double height = actual.getHeight();
        double radius = actual.getRadius();
        Assert.assertEquals(6.0 , height,DELTA);
        Assert.assertEquals(2.3, radius, DELTA);
    }
    @Test
    public void createConeWhenHeightIsOneDotOneAndRadiusIsThreeDotSevenIsValid(){
        Cone actual = new Cone(pointMock, 0.1, 3.7);
        double height = actual.getHeight();
        double radius = actual.getRadius();
        Assert.assertEquals(0.1 , height, DELTA);
        Assert.assertEquals(3.7, radius, DELTA);
    }
    @Test
    public void createConeWhenHeightIsTenDotTwoAndRadiusIsOneDotOneIsValid(){
        Cone actual = new Cone(pointMock, 10.2, 0.1);
        double height = actual.getHeight();
        double radius = actual.getRadius();
        Assert.assertEquals(10.2 , height,DELTA);
        Assert.assertEquals(0.1, radius, DELTA);
    }
    @Test
    public void createConeWhenHeightIsOneDotOneAndRadiusIsOneDotOneIsValid(){
        Cone actual = new Cone(pointMock, 0.1, 0.1);
        double height = actual.getHeight();
        double radius = actual.getRadius();
        Assert.assertEquals(0.1 , height, DELTA);
        Assert.assertEquals(0.1, radius, DELTA);
    }
    /*negative tests*/
    @Test(expected = ConeCreationException.class)
    public void createConeWhenZeroHeightAndZeroRadiusIsInvalid(){
        new Cone(pointMock, 0.0, 0.0);
    }
    @Test(expected = ConeCreationException.class)
    public void createConeWhenHeightIsNegativeAndRadiusIsPositiveIsInvalid(){
        new Cone(pointMock, -0.1, 0.1);
    }
    @Test(expected = ConeCreationException.class)
    public void createConeWhenHeightIsNegativeAndRadiusIsZeroIsInvalid(){
        new Cone(pointMock, -0.1, 0.0);
    }
    @Test(expected = ConeCreationException.class)
    public void createConeWhenZeroHeightAndNegativeRadiusIsInvalid(){
        new Cone(pointMock, 0.0, -0.1);
    }
    @Test(expected = ConeCreationException.class)
    public void createConeWhenZeroHeightAndPositiveRadiusIsInvalid(){
        new Cone(pointMock, 0.0, 0.1);
    }
    @Test(expected = ConeCreationException.class)
    public void createConeWhenPositiveHeightAndZeroRadiusIsInvalid(){
        new Cone(pointMock, 0.1, 0.0);
    }

}
