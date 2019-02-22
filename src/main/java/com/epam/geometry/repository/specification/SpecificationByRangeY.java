package com.epam.geometry.repository.specification;

import com.epam.geometry.entity.Point;
import com.epam.geometry.observer.ConeObservable;
import com.epam.geometry.repository.specification.Specification;

public class SpecificationByRangeY implements Specification<ConeObservable> {
    private double minY;
    private double maxY;

    public SpecificationByRangeY(double minY, double maxY) {
        this.minY = minY;
        this.maxY = maxY;
    }

    @Override
    public boolean specified(ConeObservable item) {
        Point centre = item.getCentre();
        double y = centre.getY();
        return y > minY && y < maxY;
    }
}
