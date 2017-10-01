package huskyhacks3.world.data;

import java.util.LinkedList;

/**
 * Created by david on 10/1/2017.
 */
public class FiniteLinkedList<E> {
    private LinkedList<E> linkedList;
    private final int capacity;

    public FiniteLinkedList(int capacity, E defaultValue) {
        this.capacity = capacity;
        this.linkedList = new LinkedList<>();
        for (int i = 0; i < capacity; i++) {
            linkedList.add(defaultValue);
        }
    }

    public void append(E element) {
        if (isMaxCapacity()) {
            linkedList.removeFirst();
        }
        linkedList.addLast(element);
    }

    public void prepend(E element) {
        if (isMaxCapacity()) {
            linkedList.removeLast();
        }
        linkedList.addFirst(element);
    }

    private boolean isMaxCapacity() {
        return capacity == linkedList.size();
    }

    public E get(int n) {
        if (n >= capacity || n < 0) {
            throw new IndexOutOfBoundsException("index: " + n + ", size: " + linkedList.size());
        } else {
            return linkedList.get(n);
        }
    }

    public void set(int n, E element) {
        linkedList.set(n, element);
    }

}
