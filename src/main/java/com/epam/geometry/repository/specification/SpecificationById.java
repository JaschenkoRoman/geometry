package com.epam.geometry.repository.specification;

import com.epam.geometry.observer.ConeObservable;
import com.epam.geometry.repository.specification.Specification;

public class SpecificationById implements Specification<ConeObservable> {
    private Integer desiredId;
    public SpecificationById(Integer desiredId) {
        this.desiredId = desiredId;
    }

        @Override
    public boolean specified(ConeObservable item) {
        Integer id = item.getId();
        return id.equals(desiredId);
    }
}
