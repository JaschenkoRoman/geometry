package com.epam.geometry.repository.specification;

import com.epam.geometry.logic.Calculator;
import com.epam.geometry.observer.ConeObservable;
import com.epam.geometry.repository.specification.Specification;

public class SpecificationByVolumeRange implements Specification<ConeObservable> {
    private double minVolume;
    private double maxVolume;
    private Calculator calculator;

    public SpecificationByVolumeRange(double minVolume, double maxVolume, Calculator calculator) {
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
        this.calculator = calculator;
    }

    @Override
    public boolean specified(ConeObservable item) {
        double volume = calculator.volume(item);
        return volume > minVolume && volume < maxVolume;
    }
}
