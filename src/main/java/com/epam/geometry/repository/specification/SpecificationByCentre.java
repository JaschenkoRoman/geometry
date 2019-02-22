package com.epam.geometry.repository.specification;

import com.epam.geometry.entity.Point;
import com.epam.geometry.observer.ConeObservable;
import com.epam.geometry.repository.specification.Specification;

public class SpecificationByCentre implements Specification<ConeObservable> {
    private Point centre;

    public SpecificationByCentre(Point centre) {
        this.centre = centre;
    }

    @Override
    public boolean specified(ConeObservable item) {
        Point itemCentre = item.getCentre();
        return itemCentre.equals(centre);
    }
}
