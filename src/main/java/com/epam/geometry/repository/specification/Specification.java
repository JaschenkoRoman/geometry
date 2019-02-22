package com.epam.geometry.repository.specification;

public interface Specification<T> {
    boolean specified(T item);
}
