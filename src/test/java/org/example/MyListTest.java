package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

public class MyListTest {
  @Test
  public void addElementInMyListTest() {
    MyList<Integer> list = new MyList<>();
    list.add(0);
    list.add(1);
    list.add(2);

    Assertions.assertEquals(0, (int) list.get(0));
    Assertions.assertEquals(2, (int) list.get(2));
    Assertions.assertEquals(3, list.size());
  }
  @Test
  public void getElementInMyListTest() {
    MyList<Integer> list = new MyList<>();
    list.add(0);
    list.add(1);
    list.add(2);

    int firstElement = 0;
    int lastElement = 2;
    int getElementOfMyList = 1;

    int actualFirstElement = list.get(0);
    int actualLastElement = list.get(2);
    int actualGetElementOfMyList = list.get(1);

    Assertions.assertEquals(firstElement, actualFirstElement);
    Assertions.assertEquals(lastElement, actualLastElement);
    Assertions.assertEquals(getElementOfMyList, actualGetElementOfMyList);
  }

  @Test
  public void resizeMyListTest() {
    MyList<Integer> list = new MyList<>(2);
    list.add(0);
    list.add(1);
    list.add(2);

    Assertions.assertEquals(0, (int) list.get(0));
    Assertions.assertEquals(2, (int) list.get(2));
    Assertions.assertEquals(3, list.size());
  }

  @Test
  public void removeElementFromMyListTest() {
    MyList<Integer> list = new MyList<>();
    list.add(0);
    list.add(1);
    list.add(2);

    Assertions.assertEquals(0, (int) list.get(0));
    Assertions.assertEquals(2, (int) list.get(2));
    Assertions.assertEquals(1, (int) list.remove(1));
  }

  @Test
  public void iteratorHasNextTest() {
    MyList<Integer> list = new MyList<>(2);
    list.add(0);
    list.add(1);
    list.add(2);

    Iterator<Integer> iterator = list.iterator();

    Assertions.assertEquals(true, iterator.hasNext());
    Assertions.assertEquals(0, iterator.next());
    Assertions.assertEquals(true, iterator.hasNext());
    Assertions.assertEquals(1, iterator.next());
    Assertions.assertEquals(true, iterator.hasNext());
    Assertions.assertEquals(2, iterator.next());
    Assertions.assertEquals(false, iterator.hasNext());
  }

  @Test
  public void iteratorRemoveTest() {
    MyList<Integer> list = new MyList<>(2);
    list.add(0);
    list.add(1);
    list.add(2);

    Iterator<Integer> iterator = list.iterator();

    iterator.remove();

    Assertions.assertEquals(1, list.get(0));

  }
}
