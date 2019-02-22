package com.epam.geometry.comparator;

import com.epam.geometry.observer.ConeObservable;

import java.util.Comparator;

public class IdComparator implements Comparator<ConeObservable> {
    @Override
    public int compare(ConeObservable o1, ConeObservable o2) {
        return o1.getId() - o2.getId();
    }
}
