package com.epam.geometry.repository.specification;

import com.epam.geometry.entity.Point;
import com.epam.geometry.observer.ConeObservable;
import com.epam.geometry.repository.specification.Specification;

public class SpecificationByRangeX implements Specification<ConeObservable> {
    private double minX;
    private double maxX;

    public SpecificationByRangeX(double minX, double maxX) {
        this.minX = minX;
        this.maxX = maxX;
    }

    @Override
    public boolean specified(ConeObservable item) {
        Point centre = item.getCentre();
        double x = centre.getX();
        return x > minX && x < maxX;
    }
}
