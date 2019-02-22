package com.epam.geometry.observer;

import com.epam.geometry.entity.ConeParameters;
import com.epam.geometry.logic.Calculator;

import java.util.HashMap;
import java.util.Map;

public class ConeObserver implements Observer<ConeObservable> {
    private static ConeObserver instance;
    private Map<Integer, ConeParameters> coneParametersMap = new HashMap<>();
    private final Calculator calculator;

    private ConeObserver(Calculator calculator) {
        this.calculator = calculator;
    }

    public static ConeObserver getInstance(Calculator calculator){
        if(instance == null) {
            instance = new ConeObserver(calculator);
        }
        return instance;
    }
    @Override
    public void update(ConeObservable item) {
        double area = calculator.area(item);
        double volume = calculator.volume(item);
        boolean isSituatedOnTheAxisSurface = calculator.isSituatedOnTheAxisSurface(item);
        ConeParameters parameters = new ConeParameters(area, volume, isSituatedOnTheAxisSurface);
        coneParametersMap.put(item.getId(), parameters);
    }

    public ConeParameters getParameters(Integer id){
        return coneParametersMap.get(id);
    }
}
