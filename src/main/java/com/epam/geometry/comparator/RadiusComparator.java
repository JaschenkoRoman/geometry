package com.epam.geometry.comparator;

import com.epam.geometry.observer.ConeObservable;

import java.util.Comparator;

public class RadiusComparator implements Comparator<ConeObservable> {
    @Override
    public int compare(ConeObservable o1, ConeObservable o2) {
        double radius1 = o1.getRadius();
        double radius2 = o2.getRadius();
        return Double.compare(radius1, radius2);
    }
}
