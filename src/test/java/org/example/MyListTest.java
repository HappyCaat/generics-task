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

    Assertions.assertEquals(0, list.get(0));
    Assertions.assertEquals(2, list.get(2));
    Assertions.assertEquals(3, list.size());
  }
  @Test
  public void getElementInMyListTest() {
    MyList<Integer> list = new MyList<>();
    list.add(0);
    list.add(1);
    list.add(2);

    Assertions.assertEquals(0, list.get(0));
    Assertions.assertEquals(2, list.get(2));
    Assertions.assertEquals(1, list.get(1));
  }

  @Test
  public void resizeMyListTest() {
    MyList<Integer> list = new MyList<>(2);
    list.add(0);
    list.add(1);
    list.add(2);

    Assertions.assertEquals(0, list.get(0));
    Assertions.assertEquals(2, list.get(2));
    Assertions.assertEquals(3, list.size());
  }

  @Test
  public void removeElementFromMyListTest() {
    MyList<Integer> list = new MyList<>();
    list.add(0);
    list.add(1);
    list.add(2);

    Assertions.assertEquals(0, list.get(0));
    Assertions.assertEquals(2, list.get(2));
    Assertions.assertEquals(1, list.remove(1));
  }

  @Test
  public void sizeOfMyListTest() {
    MyList<Integer> list = new MyList<>();
    list.add(1);
    list.add(2);
    list.add(3);

    Assertions.assertEquals(3, list.size());
  }

  @Test
  public void mapCheckedOfMyListTest() {
    MyList<Double> list = new MyList<>();
    MyList<Integer> listInt = new MyList<>();
    list.add(1.0);
    list.add(2.0);
    list.add(3.0);
    listInt.add(1);
    listInt.add(2);
    listInt.add(3);

    Assertions.assertEquals(listInt, list.map(Double::intValue));
    Assertions.assertEquals(list, listInt.map(Integer::doubleValue));

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

  @Test
  public void toStringTest() {
    MyList<Integer> list = new MyList<>();
    list.add(0);
    list.add(1);
    list.add(2);

    Assertions.assertEquals("[0,1,2,null,null,null,null,null,null,null]", String.valueOf(list));
  }

  @Test
  public void hashCodeTest() {
    MyList<Integer> list1 =new MyList<>();
    MyList<Integer> list2 =new MyList<>();
    list1.add(1);
    list2.add(2);

    Assertions.assertNotEquals(list1.hashCode(), list2.hashCode());
  }

  @Test
  public void equalsTest() {
    MyList<Integer> trueList1 = new MyList<>();
    MyList<Integer> trueList2 = new MyList<>();
    MyList<Integer> falseList1 = new MyList<>();
    MyList<Integer> falseList2 = new MyList<>();
    trueList1.add(3);
    trueList2.add(3);
    falseList1.add(5);
    falseList1.add(7);

    Assertions.assertEquals(true, trueList1.equals(trueList2));
    Assertions.assertNotEquals(true, falseList1.equals(falseList2));
  }
}