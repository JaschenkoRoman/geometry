package com.epam.geometry.validator;


public class ConeValidator {
    /*checks: height and radius > 0*/
    public boolean isCone(double[] coneData){
        if(coneData.length < 5) {
            return false;
        }
        double height = coneData[3];
        double radius = coneData[4];
        return height > 0 && radius > 0;
    }
}
