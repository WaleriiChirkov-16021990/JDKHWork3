package org.example.repositoryTask;

import java.util.List;
import java.util.Optional;

public interface MyRepository<T> {
    void save();
    void add(T entity);
    void delete(T entity);
    void update(T entity, T update);
    T find(int id);
    List<T> findAll();
    void read();
}
