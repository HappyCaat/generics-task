package org.example;

import java.util.function.Function;

public class MyList<Integer> {

    private static final int DEFAULT_CAPACITY = 10;
    private static int[] myList = new int[DEFAULT_CAPACITY];
    private static int sizeOfArray = 0;

    public void add(Integer o) {
        throw new RuntimeException("Not implemented");
    }

    public Object get(int index) {
        throw new RuntimeException("Not implemented");
    }

    private void resize() {
        int[] newMyList = new int[DEFAULT_CAPACITY * 2];
        System.arraycopy(myList, 0, newMyList, 0, sizeOfArray);
        myList = newMyList;

    }

    public Object remove(int index) {
        throw new RuntimeException("Not implemented");
    }

    public MyList map(Function f) {
        throw new RuntimeException("Not implemented");
    }

    public int size() {
        return sizeOfArray;
    }
}
