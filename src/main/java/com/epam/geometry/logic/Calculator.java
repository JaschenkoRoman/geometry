package com.epam.geometry.logic;

import com.epam.geometry.entity.Cone;
import com.epam.geometry.entity.Plain;
import com.epam.geometry.entity.Point;

import static java.lang.Math.*;

public class Calculator {
    public double area(Cone cone){
        double radius = cone.getRadius();
        double height = cone.getHeight();
        double area = PI * radius * (radius + sqrt(pow(radius, 2) + pow(height, 2)));
        return area;
    }
    public double volume(Cone cone){
        double radius = cone.getRadius();
        double height = cone.getHeight();
        double volume = height * PI * pow(radius, 2) / 3;
        return volume;
    }

    /*returns -1 if plain doesn't cross the cone*/
    public double volumeRatio(Cone cone, Plain plain){
        double ratio = -1;
        double plainHeight = plain.getHeight();
        double coneHeight = cone.getHeight();
        double coneRadius = cone.getRadius();
        Point coneCentre = cone.getCentre();
        if(plainHeight > 0 && plainHeight < coneHeight){
            double wholeConeVolume = volume(cone);
            double upperConeHeight = coneHeight - plainHeight;
            double upperConeRadius = coneRadius * upperConeHeight/coneHeight;
            double upperConeVolume = volume(new Cone(coneCentre, upperConeHeight, upperConeRadius));
            ratio = upperConeVolume / (wholeConeVolume - upperConeVolume);
        }
        return ratio;
    }
    public boolean isSituatedOnTheAxisSurface(Cone cone){
        Point centre = cone.getCentre();
        double x = centre.getX();
        double y = centre.getY();
        double z = centre.getZ();
        double zero = 0.0d;
        return Double.compare(x, zero) == 0 || Double.compare(y, zero) == 0 || Double.compare(z, zero) == 0;
    }
}
