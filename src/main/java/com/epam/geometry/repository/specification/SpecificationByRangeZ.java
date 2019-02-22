package com.epam.geometry.repository.specification;

import com.epam.geometry.entity.Point;
import com.epam.geometry.observer.ConeObservable;
import com.epam.geometry.repository.specification.Specification;

public class SpecificationByRangeZ implements Specification<ConeObservable> {
    private double minZ;
    private double maxZ;

    public SpecificationByRangeZ(double minZ, double maxZ) {
        this.minZ = minZ;
        this.maxZ = maxZ;
    }

    @Override
    public boolean specified(ConeObservable item) {
        Point centre = item.getCentre();
        double z = centre.getZ();
        return z > minZ && z < maxZ;
    }
}
