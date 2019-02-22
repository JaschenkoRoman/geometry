package com.epam.geometry.repository;

import com.epam.geometry.repository.specification.Specification;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public interface Repository<T> {
    void add(T item);
    void addAll(List<T> items);
    void update(T item);
    void remove(T item);
    void removeAll(List<T> items);
    List<T> findAll();
    List<T> findAll(Comparator<T> comparator);
    List<T> query(Specification specification);
    List<T> query(Specification specification, Comparator<T> comparator);
}
