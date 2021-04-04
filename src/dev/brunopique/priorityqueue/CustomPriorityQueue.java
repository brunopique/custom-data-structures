package dev.brunopique.priorityqueue;

import java.util.ArrayList;
import java.util.List;

public class CustomPriorityQueue {

    private final List<Integer> priorityQueue = new ArrayList<>();

    public void add(Integer number) {
        int lastIndex = lastIndex();

        priorityQueue.add(number);

        if (number < lastIndex)
            prioritise();
    }

    private void prioritise() {
        int numberToBeMoved;
        for (int i =  priorityQueue.size() - 1; i > 0; i--) {
            if (priorityQueue.get(i) < priorityQueue.get(i - 1)) {
                numberToBeMoved = priorityQueue.get(i);
                priorityQueue.set(i, priorityQueue.get(i - 1));
                priorityQueue.set(i - 1, numberToBeMoved);
            }
        }
    }

    public boolean isEmpty() {
        return priorityQueue.isEmpty();
    }

    private Integer lastIndex() {
        if (isEmpty())
            return 0;
        else
            return priorityQueue.get(priorityQueue.size() - 1);
    }

    public Integer remove() {
        if (isEmpty())
            throw new IllegalStateException();
        return priorityQueue.remove(priorityQueue.size() - 1);
    }

    @Override
    public String toString() {
        return "CustomPriorityQueue{" +
                "priorityQueue=" + priorityQueue +
                '}';
    }
}
