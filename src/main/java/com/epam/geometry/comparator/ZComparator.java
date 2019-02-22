package com.epam.geometry.comparator;

import com.epam.geometry.entity.Point;
import com.epam.geometry.observer.ConeObservable;

import java.util.Comparator;

public class ZComparator implements Comparator<ConeObservable> {
    @Override
    public int compare(ConeObservable o1, ConeObservable o2) {
        Point centre1 = o1.getCentre();
        Point centre2 = o2.getCentre();
        double z1 = centre1.getZ();
        double z2 = centre2.getZ();
        return Double.compare(z1, z2);
    }
}
