package org.example.iteratorTask;

import java.util.Iterator;

import java.util.Arrays;
import java.util.List;

public class GenericArray<T> {
    List<T> arr;
    GenericIterator<T> iterator;

    GenericArray(List<T> arr) {
        this.arr = arr;
        iterator = new GenericIterator<>(this.arr);
    }


    public void add(T t) {
        arr.add(t);
    }

    public void remove(T t) {
        if (arr.contains(t)) {
            arr.remove(t);
        }
    }

    public Integer find(T t) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).equals(t)) return i;
        }
        return null;
    }

    public String info() {
        return arr.toString();
    }


//================================================================

    public class GenericIterator<T> implements Iterator<T>, Iterable<T> {
        private List<T> arr;
        private Integer index = 0;

        GenericIterator(List<T> arr) {
            this.arr = arr;
        }

        @Override
        public boolean hasNext() {
            return (arr.size() > index);
        }

        @Override
        public T next() {
            if (hasNext()) {
                return arr.get(index++);
            }
            return null;
        }

        @Override
        public Iterator<T> iterator() {
            return new GenericIterator<>(arr);
        }


    }
}

