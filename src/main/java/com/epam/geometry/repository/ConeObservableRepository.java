package com.epam.geometry.repository;

import com.epam.geometry.observer.ConeObservable;
import com.epam.geometry.repository.specification.Specification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

public class ConeObservableRepository implements Repository<ConeObservable> {
    private Map<Integer, ConeObservable> coneObservableStorage;
    private Logger logger = LoggerFactory.getLogger(ConeObservableRepository.class);

    public ConeObservableRepository() {
        logger.info("ConeObservableRepository " + this.toString() + " has been created");
        this.coneObservableStorage = new HashMap<>();
    }
    @Override
    public void save(ConeObservable item) {
        coneObservableStorage.put(item.getId(), item);
    }

    @Override
    public void saveAll(List<ConeObservable> items) {
        items.parallelStream().forEach(this::save);
    }

    @Override
    public void remove(ConeObservable item) {
        coneObservableStorage.remove(item);
    }

    @Override
    public void removeAll(List<ConeObservable> items) {
        items.parallelStream().forEach(this::remove);
    }

    @Override
    public List<ConeObservable> query(Specification specification) {
        return coneObservableStorage
                .values()
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
