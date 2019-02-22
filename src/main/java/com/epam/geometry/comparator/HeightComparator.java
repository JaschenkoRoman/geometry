package com.epam.geometry.comparator;

import com.epam.geometry.observer.ConeObservable;

import java.util.Comparator;

public class HeightComparator implements Comparator<ConeObservable> {
    @Override
    public int compare(ConeObservable o1, ConeObservable o2) {
        double height1 = o1.getHeight();
        double height2 = o2.getHeight();
        return Double.compare(height1, height2);
    }
}
