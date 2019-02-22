package com.epam.geometry.repository.specification;

import com.epam.geometry.observer.ConeObservable;
import com.epam.geometry.repository.specification.Specification;

public class SpecificationByHeightRange implements Specification<ConeObservable> {
    private double minHeight;
    private double maxHeight;

    public SpecificationByHeightRange(double minHeight, double maxHeight) {
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
    }

    @Override
    public boolean specified(ConeObservable item) {
        double height = item.getHeight();
        return height > minHeight && height < maxHeight;
    }
}
