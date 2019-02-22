package com.epam.geometry.validator;

import org.junit.Assert;
import org.junit.Test;


public class ValidatorTests {
    private final ConeValidator validator = new ConeValidator();
    @Test
    public void ShouldValidateWhenConeHasPositiveHeightAndPositiveRadius(){
        /*Given*/
        double[] coneData = new double[] {2.2, -3.1, -5.2, 0.1, 0.1};
        /*When*/
        boolean isCone = validator.isCone(coneData);
        /*Then*/
        Assert.assertTrue(isCone);
    }
    @Test
    public void ShouldValidateWhenConeHasNegativeHeightAndPositiveRadius(){
        /*Given*/
        double[] coneData = new double[] {2.0, -3.1, -5.4, -0.1, 0.1};
        /*When*/
        boolean isCone = validator.isCone(coneData);
        /*Then*/
        Assert.assertFalse(isCone);
    }
    @Test
    public void ShouldValidateWhenConeHasPositiveHeightAndNegativeRadius(){
        /*Given*/
        double[] coneData = new double[] {2.2, -3.4, -5.1, 0.1, -0.1};
        /*When*/
        boolean isCone = validator.isCone(coneData);
        /*Then*/
        Assert.assertFalse(isCone);
    }
    @Test
    public void ShouldValidateWhenConeHasNegativeHeightAndNegativeRadius(){
        /*Given*/
        double[] coneData = new double[] {2.6, -3.5, -5.1, -0.1, -0.1};
        /*When*/
        boolean isCone = validator.isCone(coneData);
        /*Then*/
        Assert.assertFalse(isCone);
    }
    @Test
    public void ShouldValidateWhenConeHasZeroHeightAndZeroRadius(){
        /*Given*/
        double[] coneData = new double[] {2.3, -3.4, -5.4, 0.0, 0.0};
        /*When*/
        boolean isCone = validator.isCone(coneData);
        /*Then*/
        Assert.assertFalse(isCone);
    }
    @Test
    public void ShouldValidateWhenConeHasPositiveHeightAndZeroRadius(){
        /*Given*/
        double[] coneData = new double[] {2.2, -3.5, -5.5, 0.1, 0.0};
        /*When*/
        boolean isCone = validator.isCone(coneData);
        /*Then*/
        Assert.assertFalse(isCone);
    }
    @Test
    public void ShouldValidateWhenConeHasZeroHeightAndPositiveRadius(){
        /*Given*/
        double[] coneData = new double[] {2.6, -3.6, -5.8, 0.0, 0.1};
        boolean isCone = validator.isCone(coneData);
        Assert.assertFalse(isCone);
    }
    @Test
    public void ShouldValidateWhenConeHasNegativeHeightAndZeroRadius(){
        /*Given*/
        double[] coneData = new double[] {2.4, -3.7, -5.0, -0.1, 0.0};
        /*When*/
        boolean isCone = validator.isCone(coneData);
        /*Then*/
        Assert.assertFalse(isCone);
    }
    @Test
    public void ShouldValidateWhenConeHasZeroHeightAndNegativeRadius(){
        /*Given*/
        double[] coneData = new double[] {2.8, -3.4, -5.6, 0.0, -0.1};
        /*When*/
        boolean isCone = validator.isCone(coneData);
        /*Then*/
        Assert.assertFalse(isCone);
    }
    @Test
    public void ShouldValidateWhenConeHasOnlyFourParameters(){
        /*Given*/
        double[] coneData = new double[] {2.8, -3.4, -5.6, 4.0};
        /*When*/
        boolean isCone = validator.isCone(coneData);
        /*Then*/
        Assert.assertFalse(isCone);
    }
}
