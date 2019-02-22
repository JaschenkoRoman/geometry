package com.epam.geometry.repository;

import com.epam.geometry.observer.ConeObservable;
import com.epam.geometry.repository.specification.Specification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

public class ConeObservableRepository implements Repository<ConeObservable> {
    private Set<ConeObservable> coneObservableStorage;
    private Logger logger = LoggerFactory.getLogger(ConeObservableRepository.class);
    @Override
    public void add(ConeObservable item) {
        List<ConeObservable> same = coneObservableStorage
                .stream()
                .filter(cone -> cone.getId().equals(item.getId()))
                .collect(Collectors.toList());
        coneObservableStorage.removeAll(same);
        coneObservableStorage.add(item);
    }

    public ConeObservableRepository() {
        logger.info("ConeObservableRepository " + this.toString() + " has been created");
        this.coneObservableStorage = new HashSet<>();
    }
    public ConeObservableRepository(Integer initialCapacity) {
        logger.info("ConeObservableRepository " + this.toString() + " has been created");
        this.coneObservableStorage = new HashSet<>(initialCapacity);
    }
    @Override
    public void addAll(List<ConeObservable> items) {
        items.stream().forEach(this::add);
    }

    @Override
    public void update(ConeObservable item) { add(item);
    }

    @Override
    public void remove(ConeObservable item) {
        coneObservableStorage.remove(item);
    }

    @Override
    public void removeAll(List<ConeObservable> items) {
        coneObservableStorage.removeAll(items);
    }

    @Override
    public List<ConeObservable> findAll() {
        return new ArrayList<>(coneObservableStorage);
    }

    @Override
    public List<ConeObservable> findAll(Comparator<ConeObservable> comparator) {
        return coneObservableStorage
                .stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    @Override
    public List<ConeObservable> query(Specification specification) {
        return coneObservableStorage
                .parallelStream()
                .filter(specification::specified)
                .collect(Collectors.toList());
    }

    @Override
    public List<ConeObservable> query(Specification specification, Comparator<ConeObservable> comparator) {
        return query(specification)
                .stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }
}
