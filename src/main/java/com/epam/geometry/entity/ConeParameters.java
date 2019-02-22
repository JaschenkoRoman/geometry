package com.epam.geometry.entity;

public class ConeParameters {
    private final double area;
    private final double volume;
    private final boolean isSituatedOnTheAxisSurface;

    public ConeParameters(double area, double volume, boolean isSituatedOnTheAxisSurface) {
        this.area = area;
        this.volume = volume;
        this.isSituatedOnTheAxisSurface = isSituatedOnTheAxisSurface;
    }

    public double getArea() {
        return area;
    }

    public double getVolume() {
        return volume;
    }

    public boolean isSituatedOnTheAxisSurface() {
        return isSituatedOnTheAxisSurface;
    }
}
