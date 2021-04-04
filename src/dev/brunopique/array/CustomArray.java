package dev.brunopique.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class CustomArray extends ArrayList {
    private int[] items;
    private int size;

    @Override
    public String toString() {
        return "CustomArray{" +
                "items=" + Arrays.toString(items) +
                ", size=" + size +
                '}';
    }

    public CustomArray(int length) {
        items = new int[length];
    }

    public void insert(int item) {
        shouldArraySizeBeDoubled();
        items[size++] = item;
    }

    private void shouldArraySizeBeDoubled() {
        if (items.length == size) {
            int[] arrayCopy = items;
            items = new int[size * 2];
            for (int i = 0; i < size; i++)
                items[i] = arrayCopy[i];
        }
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(items[i]);
        }
    }

    public int removeAt(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException();
        int removedItem = items[index];
        for (int i = index; i < size; i++)
            items[i] = items[i + 1];
        size--;
        return removedItem;
    }

    public int getSize() {
        return size;
    }

    public int max() {
        return Arrays.stream(items)
                .max()
                .orElse(0);
    }

    public List<Integer> intersect (CustomArray otherArray) {
        List<Integer> numbers = Arrays.stream(items)
                                        .distinct()
                                        .boxed()
                                        .collect(toList());
        List<Integer> numbersOtherArray = Arrays.stream(otherArray.items)
                                                    .distinct()
                                                    .boxed()
                                                    .collect(toList());
        numbers.retainAll(numbersOtherArray);
        return numbers;
    }

    public int[] reverseArray() {
        int[] reversedArray = new int[size];
        for (int i = 0; i < size; i++) {
            reversedArray[i] = items[size - i - 1];
        }
        items = reversedArray;
        return items;
    }

    public int insertAt(int item, int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException();
        shouldArraySizeBeDoubled();
        for (int i = size - 1; i >= index; i--)
            items[i + 1] = items[i];
        items[index] = item;
        size++;
        return item;
    }
}
