package com.javatechnology.practice.lab5.Repository;

import java.util.List;

public interface L5Repository<T,U> {
    U add(T product);
    boolean update(T product);
    boolean remove(T product);
    boolean removeByID(U id);
    T get(U id);
    List<T> getAll();
}
