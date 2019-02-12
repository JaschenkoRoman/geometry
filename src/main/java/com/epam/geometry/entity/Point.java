package com.epam.geometry.entity;

public class Point {
    private final double x;
    private final double y;
    private final double z;

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (int)Double.doubleToLongBits(x);
        result = 31 * result + (int)Double.doubleToLongBits(y);
        result = 31* result + (int)Double.doubleToLongBits(z);
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
        Point point = (Point) obj;
        return Double.compare(x, point.x) == 0 &&
                Double.compare(y, point.y) == 0 &&
                Double.compare(z, point.z) == 0;
    }

    @Override
    public String toString() {
        return "Point" + "[" + x + ", " + y + ", " + z + "]";
    }
}
