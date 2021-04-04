package dev.brunopique.queuereverser;

import java.util.Queue;
import java.util.Stack;

public class CustomQueueReverser <T> {

    public void reverse(Queue<T> queue) {

        final var reversedQueue = new Stack<T>();

        while (!queue.isEmpty())
            reversedQueue.push(queue.remove());

        while(!reversedQueue.isEmpty())
            queue.add(reversedQueue.pop());

        System.out.println("queue = " + queue);
    }
}
