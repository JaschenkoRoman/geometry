package com.epam.geometry.repository.specification;

import com.epam.geometry.observer.ConeObservable;
import com.epam.geometry.repository.specification.Specification;

public class SpecificationByRadiusRange implements Specification<ConeObservable> {
    private double minRadius;
    private double maxRadius;

    public SpecificationByRadiusRange(double minRadius, double maxRadius) {
        this.minRadius = minRadius;
        this.maxRadius = maxRadius;
    }

    @Override
    public boolean specified(ConeObservable item) {
        double radius = item.getRadius();
        return radius > minRadius && radius < maxRadius;
    }
}
