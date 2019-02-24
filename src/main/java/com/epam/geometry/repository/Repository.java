package com.epam.geometry.repository;

import com.epam.geometry.repository.specification.Specification;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public interface Repository<T> {
    void save(T item);
    void saveAll(List<T> items);
    void remove(T item);
    void removeAll(List<T> items);
    List<T> query(Specification specification);
    List<T> query(Specification specification, Comparator<T> comparator);
}
