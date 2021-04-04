package dev.brunopique.doublestack;

import java.util.Arrays;

public class CustomDoubleStack {

    private int[] stack = new int[5];
    private int sizeStackOne = 0;
    private int sizeStackTwo = 1;
    private int[] stackTemp = new int[0];

    // 0 1 2 3 4 5 6 7 8 9 10
    // a b a b a b a b a b  a

    public void push1(int number) {
        if (isFull())
            doubleStackSize(sizeStackOne);
        stack[sizeStackOne] = number;
        sizeStackOne += 2;
    }

    public void push2(int number) {
        if (isFull())
            doubleStackSize(sizeStackTwo);
        stack[sizeStackTwo] = number;
        sizeStackTwo += 2;
    }

    private boolean isFull() {
        return sizeStackOne >= stack.length ||
                sizeStackTwo >= stack.length;
    }

    private void doubleStackSize(int size) {
        stackTemp = Arrays.copyOf(stack,  size  * 2);
        stack = stackTemp;
    }

    public int pop1() {
        if (isEmpty1())
            throw new IllegalStateException();

        int deletedNumber = stack[sizeStackOne];
        stack[sizeStackOne] = 0;
        sizeStackOne -= 2;
        return deletedNumber;
    }

    public int pop2() {
        if (isEmpty2())
            throw new IllegalStateException();

        int deletedNumber = stack[sizeStackTwo];
        stack[sizeStackTwo] = 0;
        sizeStackTwo -= 2;
        return deletedNumber;
    }

    public int peek1() {
        if (isEmpty1())
            throw new IllegalStateException();

        return stack[sizeStackOne - 2];
    }

    public int peek2() {
        if (isEmpty2())
            throw new IllegalStateException();

        return stack[sizeStackTwo - 2];
    }

    public boolean isEmpty1() {
        return sizeStackOne == 0;
    }

    public boolean isEmpty2() {
        return sizeStackTwo == 1;
    }

    public boolean isFull1() {
        return sizeStackOne + 2 >  stack.length;
    }

    public boolean isFull2() {
        return sizeStackTwo + 2 >  stack.length;
    }

    @Override
    public String toString() {
        return "CustomDoubleStack{" +
                "stack=" + Arrays.toString(stack) +
                ", sizeStackOne=" + sizeStackOne +
                ", sizeStackTwo=" + sizeStackTwo +
                ", stackTemp=" + Arrays.toString(stackTemp) +
                '}';
    }
}
