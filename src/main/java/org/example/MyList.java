package org.example;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Function;

public class MyList<T extends Number> implements Iterable<T> {
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
        T element = null;
        for (int i = 0; i < sizeOfArray - 1; i++) {
            if (i == index) {
                element = myList[i];
            }
            myList[i] = myList[i + 1];
        }
        sizeOfArray--;
        return element;
    }

    public <R extends Number> MyList<R> map(Function<T, R> f) {
        MyList<R> newTypeList = new MyList<>();
        for (T t : myList) {
            newTypeList.add(f.apply(t));
        }
        return newTypeList;
    }

    public int size() {
        return myList.length;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < myList.length; i++) {
            sb.append(myList[i]).append(',');
        }
        if (sb.lastIndexOf(",") == ',') {
            sb.append(',').append(']');
        }
        return String.valueOf(sb);
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    public class MyIterator implements Iterator<T> {
        public int index;

        public MyIterator() {
            index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < myList.length && myList[index] != null;
        }

        @Override
        public T next() {
            return (T) myList[index++];
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        for (T t : myList) {
            hash = 31 * hash + ((int) t * 7777);
        }
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MyList<T> list = (MyList<T>) obj;
        return Arrays.equals(myList, list.myList);
    }    
}
