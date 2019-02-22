package com.epam.geometry.comparator;

import com.epam.geometry.entity.Point;
import com.epam.geometry.observer.ConeObservable;

import java.util.Comparator;

public class YComparator implements Comparator<ConeObservable> {
    @Override
    public int compare(ConeObservable o1, ConeObservable o2) {
        Point centre1 = o1.getCentre();
        Point centre2 = o2.getCentre();
        double y1 = centre1.getY();
        double y2 = centre2.getY();
        return Double.compare(y1, y2);
    }
}
