package org.example;

import java.util.ArrayList;
import java.util.function.Function;

public class MyList<T extends Number> {
   // ArrayList
    private static final int DEFAULT_CAPACITY = 10;
    private T[] myList;
    private static int sizeOfArray = 0;

    public void add(T o) {
        for (int i = 0; i < myList.length; i++) {
            myList[i] = o;
            sizeOfArray++;
            break;
        }
        if (sizeOfArray > myList.length - 1) {
            size();
        }
    }

    public T get(int index) {
        return myList[index];
    }

    private void resize() {
        T[] newMyList = (T[]) new Object[DEFAULT_CAPACITY * 2];
        System.arraycopy(myList, 0, newMyList, 0, sizeOfArray);
        myList = newMyList;

    }

    public T remove(int index) {
        throw new RuntimeException("Not implemented");
    }

    public MyList map(Function f) {
        throw new RuntimeException("Not implemented");
    }

    public int size() {
        return myList.length;
    }
}
