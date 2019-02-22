package com.epam.geometry.repository.specification;

import com.epam.geometry.logic.Calculator;
import com.epam.geometry.observer.ConeObservable;
import com.epam.geometry.repository.specification.Specification;

public class SpecificationByAreaRange implements Specification<ConeObservable> {
    private double minArea;
    private double maxArea;
    private Calculator calculator;

    public SpecificationByAreaRange(double minArea, double maxArea, Calculator calculator) {
        this.minArea = minArea;
        this.maxArea = maxArea;
        this.calculator = calculator;
    }

    @Override
    public boolean specified(ConeObservable item) {
        double area = calculator.area(item);
        return area > minArea && area < maxArea;
    }
}
