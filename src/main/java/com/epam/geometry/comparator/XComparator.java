package com.epam.geometry.comparator;

import com.epam.geometry.entity.Point;
import com.epam.geometry.observer.ConeObservable;

import java.util.Comparator;

public class XComparator implements Comparator<ConeObservable> {
    @Override
    public int compare(ConeObservable o1, ConeObservable o2) {
        Point centre1 = o1.getCentre();
        Point centre2 = o2.getCentre();
        double x1 = centre1.getX();
        double x2 = centre2.getX();
        return Double.compare(x1, x2);
    }
}
