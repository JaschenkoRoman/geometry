package com.epam.geometry.repository.specification;

import com.epam.geometry.observer.ConeObservable;

public class AllSpecification implements Specification<ConeObservable> {
    @Override
    public boolean specified(ConeObservable item) {
        return true;
    }
}
