package com.epam.geometry.comparator;

import com.epam.geometry.logic.Calculator;
import com.epam.geometry.observer.ConeObservable;

import java.util.Comparator;

public class AreaComparator implements Comparator<ConeObservable> {
    private Calculator calculator;
    public AreaComparator(Calculator calculator) {
        this.calculator = calculator;
    }
    @Override
    public int compare(ConeObservable o1, ConeObservable o2) {
        double area1 = calculator.area(o1);
        double area2 = calculator.area(o2);
        return Double.compare(area1, area2);
    }
}
