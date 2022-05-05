public class GenericStack<E> {

    private E[] list = (E[])new Object[10];
    private int size = 0;

    public int getSize() {
        return size;
    }

    public E peek() {
        return list[size - 1];
    }

    public void push(E o) {
        if (size >= list.length) {
            doubleList();
        }
        list[size++] = o;
    }

    public E pop() {

        return list [--size];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void doubleList() {
        E[] tempList = (E[])new Object[list.length * 2];
        System.arraycopy(list, 0, tempList, 0, list.length);
        list = tempList;
    }

    @Override
    public String toString() {
        return "" + list.length;
    }
}
