import java.util.Iterator;

/*

(Implement a doubly linked list) The MyLinkedList class used in Listing 24.6 is a one-way
directional linked list that enables one-way traversal of the list. Modify the Node class to
add the new data field name previous to refer to the previous node in the list, as follows:
       public class Node<E> {
           E element;
           Node<E> next;
           Node<E> previous;
        public Node(E e) {
            element = e;
        }
      }

Implement a new class named TwoWayLinkedList that uses a doubly linked list to store elements.
The MyLinkedList class in the text extends MyAbstractList.Define TwoWayLinkedList to extend
the java.util.AbstractSequentialList class. You need to implement all the methods defined
in MyLinkedList as well as the methods listIterator()

*/


public class Task_24_3 {
    public static void main(String[] args) {
        MyTwoWayLinkedList<String> list = new MyTwoWayLinkedList<>();
        list.add("SDU");
        list.add("12345");
        list.add("Nasim");
        list.add("87698139");
        list.add("Java");
        System.out.println(list);

        list.remove(3);
        list.removeLast();
        System.out.println(list);

        System.out.println(list.contains("SDU"));
        System.out.println(list.get(1));
        System.out.println(list.indexOf("SDU"));
        System.out.println(list.lastIndexOf("12345"));
        list.set(2, "1243123");
        System.out.println(list);

        for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
            iterator.remove();
        }
        System.out.println(list);
    }
}
