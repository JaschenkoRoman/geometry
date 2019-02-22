package com.epam.geometry.observer;

import com.epam.geometry.entity.Cone;

public interface Observer<T extends Cone> {
    void update(T item);
}
