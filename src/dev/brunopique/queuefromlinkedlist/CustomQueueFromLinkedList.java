package dev.brunopique.queuefromlinkedlist;

import java.util.LinkedList;
import java.util.List;

public class CustomQueueFromLinkedList<T> {

    private List<T> queue = new LinkedList<>();
    private final int FIRST_INDEX = 0;

    // O(1)
    public void enqueue(T item) {
        queue.add(item);
    }

    // O(1)
    public T dequeue() {
        if (queue.isEmpty())
            throw new IllegalStateException();

        return queue.remove(FIRST_INDEX);
    }

    // O(1)
    public T peek() {
        return queue.get(FIRST_INDEX);
    }

    // O(1)
    public int size() {
       return queue.size();
    }

    // O(1)
    public boolean isEmpty() {
        return queue.isEmpty();
    }


    @Override
    public String toString() {
        return "CustomQueueFromLinkedList{" +
                "queue=" + queue +
                ", FIRST_INDEX=" + FIRST_INDEX +
                '}';
    }
}
