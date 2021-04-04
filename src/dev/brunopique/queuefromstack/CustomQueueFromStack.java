package dev.brunopique.queuefromstack;

import java.util.Stack;

public class CustomQueueFromStack<T> {
    // use two stacks to change order they're removed
    /*
    FIFO != LIFO (Stacks)

    First in first out, like a line of people in the real world (first one -> action).
     */

    private Stack<T> queueStack = new Stack<>();
    private Stack<T> queueStack2 = new Stack<>();

    public void enqueue(T item) {
        queueStack.push(item);
    }

    private Stack<T> reverse(Stack<T> stack) {
        Stack<T> tempStack = new Stack<>();
        while (!stack.isEmpty())
            tempStack.push(stack.pop());
        return tempStack;
    }

    public Stack<T> reverse() {
        Stack<T> tempStack = new Stack<>();
        Stack<T> tempStack2 = (Stack<T>) queueStack.clone();
        while (!tempStack2.isEmpty())
            tempStack.push(tempStack2.pop());
        return tempStack;
    }

    public T peek() {
        queueStack2 = reverse((Stack<T>) queueStack.clone());
       return queueStack2.peek();
    }

    public T dequeue() {

        queueStack2= reverse((Stack<T>) queueStack.clone());
        T dequedItem = queueStack2.pop();

        queueStack = reverse((Stack<T>) queueStack2);

        return dequedItem;
    }

    public void reverse(int k) {
        if (k > queueStack.size())
            throw new IllegalStateException();

        Stack<T> tempStack = new Stack<>();
        queueStack2 = reverse(queueStack);

        for (int i = 0; i < k; i++)
            tempStack.push(queueStack2.pop());

        tempStack = reverse(tempStack);

        System.out.println("tempStack = " + tempStack);

        while (!tempStack.isEmpty())
            queueStack2.push(tempStack.pop());

        queueStack = reverse(queueStack2);
    }

    @Override
    public String toString() {
        return "CustomQueueFromStack{" +
                "queueStack=" + queueStack +
                ", queueStack2=" + queueStack2 +
                '}';
    }
}
