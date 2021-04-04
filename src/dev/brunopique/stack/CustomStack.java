package dev.brunopique.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomStack {

    private int[] stack = new int[5];
    private int size = 0;
    private int[] stackTemp = new int[0];
    private List<Integer> min = new ArrayList<>();

    public void push(int number) {
        if (size == stack.length)
            doubleStackSize();

        if (number < getLast())
            min.add(number);

        stack[size++] = number;
    }

    private void doubleStackSize() {
        stackTemp = Arrays.copyOf(stack, size * 2);
        stack = stackTemp;
        stackTemp = null;
    }

    private int getLast() {
        if (min.isEmpty())
            return Integer.MAX_VALUE;
        return min.get(min.size() - 1);
    }

    public int min() {
        return getLast();
    }

    public int pop() {
        if (isEmpty())
            throw new IllegalStateException();

        int deletedNumber = stack[size - 1];
        stack[--size] = 0;

        if(getLast() == deletedNumber)
            min.remove((Integer) getLast());

        return deletedNumber;
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();

        return stack[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return "CustomStack{" +
                "stack=" + Arrays.toString(stack) +
                ", size=" + size +
                ", stackTemp=" + Arrays.toString(stackTemp) +
                ", min=" + min +
                '}';
    }
}
