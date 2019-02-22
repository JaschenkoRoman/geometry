package com.epam.geometry.entity;

public class Plain {
    private final double height;

    public Plain(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (int)Double.doubleToLongBits(height);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(obj.getClass() != this.getClass()){
            return false;
        }
        Plain plain = (Plain)obj;
        return Double.compare(height, plain.height) == 0;
    }

    @Override
    public String toString() {
        return "Plain[" + height + "]";
    }
}
