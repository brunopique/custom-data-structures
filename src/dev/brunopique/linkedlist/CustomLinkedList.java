package dev.brunopique.linkedlist;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class CustomLinkedList {

    private CustomNode first;
    private CustomNode last;
    private int size;

    class CustomNode {
        private int value;
        private CustomNode next;

        public CustomNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "CustomNode{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }

        public void setNext(CustomNode next) {
            this.next = next;
        }
    }

    public CustomNode addLast(int value) {
        var node = new CustomNode(value);
        size++;
        if (isEmpty(first)) {
            first = last = node;
            return first;
        }
        else {
            last.next = node;
            last = node;
            return last;
        }
    }

    public CustomNode addFirst(int value) {
        var node = new CustomNode(value);

        if (!isEmpty(first))
            node.next = first;
        else
            last = node;

        size++;
        first = node;
        return first;
    }

    private boolean isEmpty(CustomNode customNode) {
        return customNode == null;
    }

    public int indexOf(CustomNode customNode) {
        CustomNode current = first;
        int index = 0;
        while (!isEmpty(current)) {
            if (current.equals(customNode))
                return index;
            index++;
            current = current.next;
        }
        return -1;
    }

    public boolean contains(CustomNode customNode) {
       return indexOf(customNode) != -1;
    }

    public CustomNode deleteFirst() {
        if (isEmpty(first)) {
            throw new NoSuchElementException();
        } else {
            CustomNode deletedNode = first;
            if (first.equals(last)) {
                first = last = null;
                return deletedNode;
            }
            CustomNode second = first.next;
            first.next = null;
            first = second;
            size--;
            return deletedNode;
        }
    }

    public CustomNode deleteLast() {
        if (isEmpty(first)) {
            throw new NoSuchElementException();
        } else {
            CustomNode deletedNode = last;
            if (first.equals(last)) {
                first = last = null;
                return deletedNode;
            }
            CustomNode newLast = getPrevious(last);
            newLast.next = null;
            last = newLast;
            size--;
            return deletedNode;
        }
    }

    private CustomNode getPrevious(CustomNode customNode) {
        CustomNode current = first;
        while (!current.next.equals(customNode)) {
            current = current.next;
        }
        return current;
    }

    public int getSize() {
        return size;
    }

    public List<Integer> toArrayList() {
        if (!isEmpty(first)) {
            List<Integer> linkedListToArray = new ArrayList<>();
            CustomNode current = first;
            for (int i = 0; i < size; i++) {
                linkedListToArray.add(i, current.value);
                current = current.next;
            }
            return linkedListToArray;
        } else
            return Collections.emptyList();
    }

    public void reverse() {
        if (isEmpty(first))
            throw  new NoSuchElementException();

        CustomNode current = first;
        int iterations = size;
        this.empty();
        for (int i = 0; i < iterations; i++) {
            addFirst(current.value);
            current = current.next;
        }
    }

    public void empty() {
        first = last = null;
        size = 0;
    }

    public void reverseMosh() {
        if (isEmpty(first)) return;

        var previous = first;
        var current = first.next;
        while (current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = previous;
    }

    // [10 > 20 > 30 > 40 > 50]
    //             *         *
    // K = 1 (50)
    // K = 2 (40)
    // K = 3 (30) (distance 2) (k - 1 nodes apart)
    public CustomNode getKthFromTheEnd(int k) {
        if (isEmpty(first) || k > size)
            throw new NoSuchElementException();

        CustomNode current = first;
        for (int i = 0; i < size - k; i++) {
            current = current.next;
        }
        return current;
    }

    public String getKthFromTheEndStringBuilder(int k) {
        String kthNode = "first" + ".next".repeat(size - k);

        return kthNode;
    }

    public int getKthFromTheEndMosh(int k) {
        if (isEmpty(first))
            throw new IllegalStateException();

        var a = first;
        var b = first;
        for (int i = 0; i < k - 1; i++) {
            b = b.next;
            if (b == null)
                throw new IllegalArgumentException();
        }
        while (b != last) {
            a = a.next;
            b = b.next;
        }
        return a.value;
    }

    public List<Integer> printMiddle() {
       ArrayList<Integer> nodeList = (ArrayList<Integer>) toArrayList();
       ArrayList<Integer> middleList = new ArrayList<>();
       int nodeListSize = nodeList.size();
       if (nodeListSize % 2 != 0) {
           middleList.add(nodeList.get((int) Math.ceil(nodeListSize / 2)));
       } else {
           middleList.add(nodeList.get(nodeListSize / 2 ));
           middleList.add(nodeList.get(nodeListSize / 2 + 1));
       }
       return middleList;
    }

    public void printMiddleMosh() {
        if (isEmpty(first))
            throw new IllegalStateException();

        var a = first;
        var b = first;
        while (b != last && b.next != last) {
            b = b.next.next;
            a = a.next;
        }

        if (b == last)
            System.out.println(a.value);
        else
            System.out.println(a.value + ", " + a.next.value);
    }

    public boolean hasLoop() {
        if (!isEmpty(first)) {
            CustomNode fast = first;
            CustomNode slow = first;

            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast.value == slow.value)
                    return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "CustomLinkedList{" +
                "first=" + first +
                ", last=" + last +
                ", size=" + size +
                '}';
    }
}
