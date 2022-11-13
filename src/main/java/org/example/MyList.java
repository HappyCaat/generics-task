package org.example;

import java.util.Iterator;
import java.util.function.Function;

@SuppressWarnings("unchecked")
public class  MyList<T extends Number> implements MyListInterface<T> {
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

    @Override
    public void add(T o) {
        if (sizeOfArray == innerArray.length) {
            resize();
        }
        innerArray[sizeOfArray] = o;
        sizeOfArray++;
    }

    @Override
    public T get(int index) {
        checkInBounds(index);
        return (T) innerArray[index];
    }

    private void resize() {
        Object[] newMyList = new Object[innerArray.length * 2];
        System.arraycopy(innerArray, 0, newMyList, 0, sizeOfArray);
        innerArray = newMyList;
    }

    @Override
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


    @Override
    public <R extends Number> MyList<R> map(Function<T, R> f) {
        MyList<R> newTypeList = new MyList<>();
        for (Object t : innerArray) {
            newTypeList.add(f.apply((T) t));
        }
        return newTypeList;
    }

    @Override
    public int size() {
        return sizeOfArray;
    }

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

}
