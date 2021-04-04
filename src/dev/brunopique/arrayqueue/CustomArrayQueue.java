package dev.brunopique.arrayqueue;

import java.util.ArrayList;
import java.util.List;

public class CustomArrayQueue<T> {
    // [10, 20, 30, 40, 50]
    //  ->  F           R
    // Front: 20
    // Rear: 50

    private List<T> queue = new ArrayList<>();
    private T front;
    private int frontIndex;
    private T rear;
    private int size;

    public int getSize() {
        return size;
    }

    public void enqueue(T item) {
        if (isEmpty())
            front = rear = item;
        else
            rear = item;

        queue.add(item);
        size++;
    }

    public T dequeue() {
        if (isEmpty())
            throw new IllegalStateException();

        T dequeuedItem = queue.get(frontIndex++);

        if (front.equals(rear))
            front = rear = null;
        else
            front = queue.get(frontIndex);

        size--;

        return dequeuedItem;
    }

    public boolean isEmpty() {
        return front == null && rear == null;
    }

    public T peek() {
        return front;
    }

    public boolean isFull() {
        return size == queue.size();
    }

}
