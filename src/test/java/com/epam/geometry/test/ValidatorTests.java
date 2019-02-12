package com.epam.geometry.test;

import com.epam.geometry.validator.ConeValidator;
import org.junit.Assert;
import org.junit.Test;


public class ValidatorTests {
    private final ConeValidator validator = new ConeValidator();
    @Test
    public void ConeHasPositiveHeightAndPositiveRadiusIsValid(){
        double[] coneData = new double[] {2.2, -3.1, -5.2, 0.1, 0.1};
        Assert.assertTrue(validator.isCone(coneData));
    }
    @Test
    public void ConeHasNegativeHeightAndPositiveRadiusIsInvalid(){
        double[] coneData = new double[] {2.0, -3.1, -5.4, -0.1, 0.1};
        Assert.assertFalse(validator.isCone(coneData));
    }
    @Test
    public void ConeHasPositiveHeightAndNegativeRadiusIsInvalid(){
        double[] coneData = new double[] {2.2, -3.4, -5.1, 0.1, -0.1};
        Assert.assertFalse(validator.isCone(coneData));
    }
    @Test
    public void ConeHasNegativeHeightAndNegativeRadiusIsInvalid(){
        double[] coneData = new double[] {2.6, -3.5, -5.1, -0.1, -0.1};
        Assert.assertFalse(validator.isCone(coneData));
    }
    @Test
    public void ConeHasZeroHeightAndZeroRadiusIsInvalid(){
        double[] coneData = new double[] {2.3, -3.4, -5.4, 0.0, 0.0};
        Assert.assertFalse(validator.isCone(coneData));
    }
    @Test
    public void ConeHasPositiveHeightAndZeroRadiusIsInvalid(){
        double[] coneData = new double[] {2.2, -3.5, -5.5, 0.1, 0.0};
        Assert.assertFalse(validator.isCone(coneData));
    }
    @Test
    public void ConeHasZeroHeightAndPositiveRadiusIsInvalid(){
        double[] coneData = new double[] {2.6, -3.6, -5.8, 0.0, 0.1};
        Assert.assertFalse(validator.isCone(coneData));
    }
    @Test
    public void ConeHasNegativeHeightAndZeroRadiusIsInvalid(){
        double[] coneData = new double[] {2.4, -3.7, -5.0, -0.1, 0.0};
        Assert.assertFalse(validator.isCone(coneData));
    }
    @Test
    public void ConeHasZeroHeightAndNegativeRadiusIsInvalid(){
        double[] coneData = new double[] {2.8, -3.4, -5.6, 0.0, -0.1};
        Assert.assertFalse(validator.isCone(coneData));
    }
}
