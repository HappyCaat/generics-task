package org.example;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Function;

public class  MyList<T extends Number> implements Iterable<T> {
    // ArrayList
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] innerArray;
    private int sizeOfArray;

    public MyList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Invalid capacity");
        } else {
            innerArray = new Object[capacity];
        }
    }

    public MyList() {
        innerArray = new Object[DEFAULT_CAPACITY];
    }

    public void add(T o) {
        if (sizeOfArray == innerArray.length) {
            resize();
        }
        innerArray[sizeOfArray] = o;
        sizeOfArray++;
    }

    public T get(int index) {
        checkInBounds(index);
        return (T) innerArray[index];
    }

    private void resize() {
        Object[] newMyList = new Object[innerArray.length * 2];
        System.arraycopy(innerArray, 0, newMyList, 0, sizeOfArray);
        innerArray = newMyList;
    }

    public T remove(int index) {
        checkInBounds(index);
        T element = (T) innerArray[index];
       for (int i = index; i < innerArray.length-1; i++) {
            innerArray[i] = innerArray[i+1];
        }
       sizeOfArray--;
       return element;
    }

    private void checkInBounds(int index) {
        if (index >= sizeOfArray || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    public <R extends Number> MyList<R> map(Function<T, R> f) {
        MyList<R> newTypeList = new MyList<>();
        for (int i = 0; i < innerArray.length && innerArray[i] != null; i++) {
            Object t = innerArray[i];
            newTypeList.add(f.apply((T) innerArray[i]));
        }
        return newTypeList;
    }

    public int size() {
        return sizeOfArray;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (Object t : innerArray) {
            sb.append(t).append(',');
        }
        sb.deleteCharAt(sb.lastIndexOf(",")).append(']');
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
            return index < innerArray.length && innerArray[index] != null;
        }

        @Override
        public T next() {
            return (T) innerArray[index++];
        }

        @Override
        public void remove() {
            MyList.this.remove(index);
        }
    }

    @Override
    public int hashCode() {
        int result = 1;
        for (int i = 0; i < innerArray.length && innerArray[i] != null; i++) {
            Object o = innerArray[i];
            result = 31 * result + ((int) o * 777);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        MyList<T> myList = (MyList<T>) o;
        return Arrays.equals(innerArray, myList.innerArray);
    }
}
