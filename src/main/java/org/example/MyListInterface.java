package org.example;

import java.util.function.Function;

public interface MyListInterface<T extends Number> extends Iterable<T> {
    void add(T o);

    T get(int index);

    T remove(int index);

    <R extends Number> MyList<R> map(Function<T, R> f);

    int size();
}
