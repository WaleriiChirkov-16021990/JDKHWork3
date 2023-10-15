package org.example.repositoryTask;

import java.util.List;
import java.util.Optional;

public class MyController <T>{
    private final MyService myService;

    public MyController(MyService myService) {
        this.myService = myService;
        myService.read();
    }

    public void add(T entity) {
        myService.add(entity);
    }

    public void delete(T entity) {
        myService.delete(entity);
    }

    public void update(T entity, T update) {
        myService.update(entity, update);
    }

    public T find(int id) {
        if ((T) myService.find(id) != null){
            return (T) myService.find(id);
        } else {
            System.out.println("пользователь не найден");
        }
        return null;
    }

    public List<T> findAll() {
        return myService.findAll();
    }

    public void save() {
        myService.save();
    }
}
