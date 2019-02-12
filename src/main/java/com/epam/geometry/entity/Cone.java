package com.epam.geometry.entity;

import com.epam.geometry.exception.ConeCreationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Cone {
    private final Point centre;
    private final double height;
    private final double radius;
    private Logger logger = LoggerFactory.getLogger(Cone.class);

    public Cone(Point centre, double height, double radius) {
        if(height <= 0){
            logger.error("attempt to create Cone instance with zero height");
            throw new ConeCreationException("height less than zero" + height);
        }
        if(radius <= 0){
            logger.error("attempt to create Cone instance with zero radius");
            throw new ConeCreationException("radius less than zero" + radius);
        }
        this.centre = centre;
        this.height = height;
        this.radius = radius;
    }

    public Point getCentre() {
        return centre;
    }

    public double getHeight() {
        return height;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + centre.hashCode();
        result = 31 * result + (int)Double.doubleToLongBits(height);
        result = 31* result + (int)Double.doubleToLongBits(radius);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }
        if(obj.getClass() != this.getClass()){
            return false;
        }
        Cone cone = (Cone)obj;
        return centre.equals(cone.centre) &&
                Double.compare(height, cone.height) == 0 &&
                Double.compare(radius, cone.radius) == 0;
    }

    @Override
    public String toString() {
        return "Cone: centre = " + centre.toString() + ", height = " + height + ", radius = " + radius ;
    }
}
