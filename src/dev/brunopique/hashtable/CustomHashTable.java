package dev.brunopique.hashtable;


import dev.brunopique.entry.CustomEntry;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Optional;

public class CustomHashTable {
    // k: int v: string
    // Collision: chaining linkedlists (create private class that wraps key and value)
    // LinkedList<Entry>[] [ LL, LL, LL, LL ]

    private LinkedList<CustomEntry>[] hashTable = new LinkedList[5];
    private int hashedKeyAsIndex = 0;


    public boolean put(int k, String v) {
        CustomEntry newEntry = new CustomEntry(k, v);
        if (isEntryEmpty(newEntry))
            return  false;
        hashKeyAsIndex(k);
        if (isLinkedListToBeInitialised())
            initialiseLinkedList();
        hashTable[hashedKeyAsIndex].add(newEntry);
        return true;
    }

    private boolean isEntryEmpty(CustomEntry entry) {
        return entry.getKey() == null;
    }

    private boolean hashKeyAsIndex(int key) {
        hashedKeyAsIndex = key % hashTable.length;
        return hashedKeyAsIndex < hashTable.length;
    }

    private boolean isLinkedListToBeInitialised() {
        return hashTable[hashedKeyAsIndex] == null;
    }

    private void initialiseLinkedList() {
        hashTable[hashedKeyAsIndex] = new LinkedList<>();
    }

    public String get(int k) {
        hashKeyAsIndex(k);
        if (hashTable[hashedKeyAsIndex] == null)
            throw new NoSuchElementException("No element with index: " + k);
        return hashTable[hashedKeyAsIndex].stream()
                .filter(entry -> entry.getKey().equals(k))
                .map(CustomEntry::getValue)
                .findFirst()
                .orElse("No element with that id");
    }

    public boolean remove(int k) {
        String valueToBeRemoved = get(k);
        Optional<CustomEntry> entryToBeRemoved = hashTable[hashedKeyAsIndex].stream()
                .filter(entry -> entry.getValue().equals(valueToBeRemoved))
                .findFirst();

        return hashTable[hashedKeyAsIndex].remove(entryToBeRemoved.orElse(new CustomEntry(0, "")));
    }


    @Override
    public String toString() {
        return "CustomHashTable{" +
                "hashTable=" + Arrays.toString(hashTable) +
                '}';
    }
}
