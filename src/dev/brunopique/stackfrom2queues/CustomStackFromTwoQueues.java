package dev.brunopique.stackfrom2queues;

import java.util.ArrayDeque;
import java.util.Queue;

public class CustomStackFromTwoQueues<T>{

    private Queue<T> firstQueue = new ArrayDeque<>();
    private Queue<T> secondQueue = new ArrayDeque<>();
    private T lastItem;
    private int size = 0;

    // O(1)
    public void push(T item) {
        firstQueue.add(item);
        lastItem = item;
        size++;
    }

    // O(n)
    // I could also create a variable firstItem and save it if stack is empty
    // then remove it with reference, which would make this method O(1)
    // bu then I wouldn't be using two queues
    public T pop() {
        if (isEmpty())
            throw new IllegalStateException();

        T removedItem = copyQueueMinusFirstItemAndReturnIt();

        firstQueue.remove(removedItem);

        size--;

        return removedItem;
    }

    // O(1)
    public T peek() {
        return lastItem;
    }

    // O(1)
    public int size() {
        return size;
    }

    // O(1)
    public boolean isEmpty() {
        return size < 1;
    }

    private T copyQueueMinusFirstItemAndReturnIt() {
        secondQueue.addAll(firstQueue);

        while (secondQueue.size() > 1)
            secondQueue.remove();

        return secondQueue.peek();
    }


    @Override
    public String toString() {
        return "CustomStackFromTwoQueues{" +
                "firstQueue=" + firstQueue +
                ", secondQueue=" + secondQueue +
                '}';
    }
}
