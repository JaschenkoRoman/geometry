package com.epam.geometry.comparator;

import com.epam.geometry.logic.Calculator;
import com.epam.geometry.observer.ConeObservable;

import java.util.Comparator;

public class VolumeComparator implements Comparator<ConeObservable> {
    private Calculator calculator;
    public VolumeComparator(Calculator calculator) {
        this.calculator = calculator;
    }
    @Override
    public int compare(ConeObservable o1, ConeObservable o2) {
        double volume1 = calculator.volume(o1);
        double volume2 = calculator.volume(o2);
        return Double.compare(volume1, volume2);
    }
}
