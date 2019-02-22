package com.epam.geometry.observer;

import com.epam.geometry.entity.Cone;

public interface Observable<T extends Cone> {
    void addObserver(Observer<T>  observer);
}
